import math
import datetime
import time
from django.http import HttpResponse


import numpy as np
import pandas as pd
from selenium import webdriver
from selenium.common.exceptions import TimeoutException
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.common.by import By
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait
from tensorflow.keras.models import load_model
from tensorflow.keras.utils import custom_object_scope
from tensorflow_addons.optimizers import RectifiedAdam
from tqdm import tqdm
from transformers import BertTokenizer
from transformers import TFBertModel
import cx_Oracle
from sqlalchemy import create_engine
import pandas as pd

from text.views import model, predict_load_data


def review_crawl(request):
    df3 = pd.read_csv('reviewcrolling/csv_files/test.csv')

    service = Service(executable_path='reviewcrolling/chromedriver/chromedriver.exe')
    driver = webdriver.Chrome(service=service)

    link = df3['review_url']
    location = df3['location']
    name = df3['name']

    df2 = pd.DataFrame()

    for l, loc, n in tqdm(zip(link, location, name), total=len(link)):
        reviewlist = []
        url = '{}'.format(l)
        driver.get(url)
        time.sleep(2)

        body = driver.find_element(By.TAG_NAME, 'body')

        try:

            element = WebDriverWait(driver, 10).until(
                EC.presence_of_element_located((By.CLASS_NAME, 'place_section_count'))
            )
            section_count_text = element.text
        except TimeoutException:
            # 10초 동안 요소가 나타나지 않으면 페이지 새로고침
            # print("요소를 찾을 수 없어 페이지를 새로고침합니다.")
            driver.refresh()
            time.sleep(5)

        try:
            element = WebDriverWait(driver, 10).until(
                EC.presence_of_element_located((By.CLASS_NAME, 'place_section_count'))
            )
            section_count_text = element.text
        except TimeoutException:
            # print("요소를 다시 찾을 수 없습니다.")
            continue

        section_count_text = section_count_text.replace(',', '')

        section_count = float(section_count_text)

        if section_count > 2000:
            section_count = 2000
        result = section_count / 10
        value = result
        rounded_value = math.ceil(value)
        print(rounded_value)
        time.sleep(3)

        body = driver.find_element(By.TAG_NAME, 'body')

        for i in range(rounded_value):
            body.send_keys(Keys.PAGE_DOWN)
            time.sleep(0.5)
            try:
                clickable_element = driver.find_element(By.CLASS_NAME, 'E4qxG')
                clickable_element.click()
                time.sleep(0.2)
            except Exception as e:
                # print("클릭할 요소를 찾지 못했습니다:", e)
                pass
            time.sleep(0.2)

        plus_elements = driver.find_elements(By.CLASS_NAME, 'rvCSr')

        for element in plus_elements:
            try:
                element.click()
                time.sleep(0.5)
            except Exception as e:
                break
                # print("클릭 중 오류 발생:", e)

        time.sleep(0.5)
        elements = driver.find_elements(By.CLASS_NAME, 'zPfVt')

        for element in elements:
            reviewlist.append(element.text)

        df = pd.DataFrame(reviewlist)
        df['링크'] = link

        data = {'document': df.iloc[:, 0]}
        data_df = pd.DataFrame(data)

        data_x = predict_load_data(data_df)
        predictions = model.predict(data_x)

        predict_values = [prediction[0] for prediction in predictions]
        average_sentiment = np.mean(predict_values)

        temp_df = pd.DataFrame({'name': n, 'review_url': l, 'score': average_sentiment}, index=[0])
        df2 = pd.concat([df2, temp_df], ignore_index=True)
        print(df2)
        # 여기부터는 내부 반복문 및 로직이 들어갑니다...
        # 나머지 코드는 이전과 동일하게 유지됩니다.

    # 데이터 저장 및 HTTP 응답 반환
    df2.to_csv('review_score.csv', index=False)
    engine = create_engine('oracle+cx_oracle://haru:haru0115@116.122.37.100:1521/xe')
    df2.to_sql('review', con=engine, if_exists='append', index=False)

    return HttpResponse("리뷰 크롤링 성공!!")
