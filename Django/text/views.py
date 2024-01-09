# # views.py
# from django.http import JsonResponse
# from rest_framework.decorators import api_view
# from rest_framework.parsers import JSONParser
# import pandas as pd
# from transformers import BertTokenizer, TFBertModel
# from tensorflow.keras.models import load_model
# from tensorflow.keras.utils import custom_object_scope
# from tensorflow_addons.optimizers import RectifiedAdam
# import numpy as np
# from tqdm import tqdm
#
#
# tokenizer = BertTokenizer.from_pretrained('bert-base-multilingual-cased')
#
#
# # 모델 파일 경로
# model_path = 'textmodel/finalsentense.h5'
#
#
#
# # custom_objects 매개변수를 사용하여 레이어를 등록
# with custom_object_scope({'TFBertModel': TFBertModel, 'RectifiedAdam': RectifiedAdam}):
#     model = load_model(model_path)
#
#
# model.summary()
# def convert_data(data_df):
#     global tokenizer
#
#     SEQ_LEN = 128 #SEQ_LEN : 버트에 들어갈 인풋의 길이
#     #토큰 인풋, 마스크 인풋, 세그먼트 인풋, 타겟
#     tokens, masks, segments, targets = [], [], [], []
#
#     for i in tqdm(range(len(data_df))):
#         # token : 문장을 토큰화함
#         token = tokenizer.encode(data_df[DATA_COLUMN][i], max_length=SEQ_LEN, truncation=True, padding='max_length')
#
#         # 마스크는 토큰화한 문장에서 패딩이 아닌 부분은 1, 패딩인 부분은 0으로 통일
#         # num_zeros를 구해서 패딩 처리 하기 위해서 연산
#         num_zeros = token.count(0)
#         # SEQ_LEN-num_zeros : 실제 문장의 길이를 연산
#         mask = [1]*(SEQ_LEN-num_zeros) + [0]*num_zeros
#         #print(mask)
#         # 문장의 전후관계를 구분해주는 세그먼트는 문장이 1개밖에 없으므로 모두 0
#         segment = [0]*SEQ_LEN
#
#         # 버트 인풋으로 들어가는 token, mask, segment를 tokens, segments에 각각 저장
#         tokens.append(token)
#         masks.append(mask)
#         segments.append(segment)
#
#         # 정답(긍정 : 1 부정 0)을 targets 변수에 저장해 줌
#         targets.append(data_df[LABEL_COLUMN][i])
#
#     # tokens, masks, segments, 정답 변수 targets를 numpy array로 지정
#     tokens = np.array(tokens)
#     masks = np.array(masks)
#     segments = np.array(segments)
#     targets = np.array(targets)
#
#     return [tokens, masks, segments], targets
#
# # 위에 정의한 convert_data 함수를 불러오는 함수를 정의
# def load_data(pandas_dataframe):
#     data_df = pandas_dataframe
#     data_df[DATA_COLUMN] = data_df[DATA_COLUMN].astype(str)
#     data_df[LABEL_COLUMN] = data_df[LABEL_COLUMN].astype(int)
#     data_x, data_y = convert_data(data_df)
#     return data_x, data_y
#
# SEQ_LEN = 128
# BATCH_SIZE = 20
# # 긍부정 문장을 포함하고 있는 칼럼
# DATA_COLUMN = "document"
# # 긍정인지 부정인지를 (1=긍정,0=부정) 포함하고 있는 칼럼
# LABEL_COLUMN = "label"
#
#
#
# def predict_convert_data(data_df):
#     global tokenizer
#     tokens, masks, segments = [], [], []
#
#     for i in tqdm(range(len(data_df))):
#
#         token = tokenizer.encode(data_df[DATA_COLUMN][i], max_length=SEQ_LEN, truncation=True, padding='max_length')
#         num_zeros = token.count(0)
#         mask = [1]*(SEQ_LEN-num_zeros) + [0]*num_zeros
#         segment = [0]*SEQ_LEN
#
#         tokens.append(token)
#         segments.append(segment)
#         masks.append(mask)
#
#     tokens = np.array(tokens)
#     masks = np.array(masks)
#     segments = np.array(segments)
#     return [tokens, masks, segments]
#
# # 위에 정의한 convert_data 함수를 불러오는 함수를 정의
# def predict_load_data(pandas_dataframe):
#     data_df = pandas_dataframe
#     data_df[DATA_COLUMN] = data_df[DATA_COLUMN].astype(str)
#     data_x = predict_convert_data(data_df)
#     return data_x
#
#
#
# def sentence_convert_data(data):
#     global tokenizer
#     tokens, masks, segments = [], [], []
#     token = tokenizer.encode(data, max_length=SEQ_LEN, truncation=True, padding='max_length')
#
#     num_zeros = token.count(0)
#     mask = [1]*(SEQ_LEN-num_zeros) + [0]*num_zeros
#     segment = [0]*SEQ_LEN
#
#     tokens.append(token)
#     segments.append(segment)
#     masks.append(mask)
#
#     tokens = np.array(tokens)
#     masks = np.array(masks)
#     segments = np.array(segments)
#     return [tokens, masks, segments]
#
#
# @api_view(['POST'])
# def predict(request):
#     # 데이터 파싱 (예시로 JSON 데이터를 사용)
#     data = JSONParser().parse(request)
#     # 데이터 전처리
#
#     # JSON 데이터에 'document' 키가 있는지 확인
#     if 'document' not in data or not data['document']:
#         return Response({'error': 'No document provided.'}, status=status.HTTP_400_BAD_REQUEST)
#
#     data_df = pd.DataFrame(data)
#
#     # 데이터 프레임의 감정 분석 수행
#     data_x = predict_load_data(data_df)
#     predictions = model.predict(data_x)
#
#     # 결과를 담을 리스트 초기화 및 결과 저장
#     results = [min(max(round(float(pred), 2), 0), 1) for pred in predictions.flat]
#
#     print(results)
#     # 결과 반환
#     return JsonResponse({'results': results})
