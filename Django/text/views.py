import pickle
import re
from konlpy.tag import Okt
from tensorflow.keras.preprocessing.sequence import pad_sequences
from tensorflow.keras.models import load_model

max_len = 60
stopwords = ['도', '는', '다', '의', '가', '내', '것', '이', '은', '한', '에', '하', '고', '을', '를', '인', '듯', '과', '와', '네', '들', '듯', '지', '임', '게', '만', '게임', '겜', '되', '음', '면']  # 여기 수정됨

with open('text/textmodel/tokenizer.pickle', 'rb') as handle:
    tokenizer = pickle.load(handle)

model_path = 'text/textmodel/finaltextmodel1234567.h5'
model = load_model(model_path)

okt = Okt()

def preprocess_text(sentence):
    sentence = re.sub(r'[^ㄱ-ㅎㅏ-ㅣ가-힣 ]','', sentence)
    sentence = okt.morphs(sentence)
    sentence = [word for word in sentence if not word in stopwords]
    encoded = tokenizer.texts_to_sequences([sentence])
    pad_new = pad_sequences(encoded, maxlen=max_len)
    return pad_new

def predict_load_data(new_sentence):
    new_sentence = preprocess_text(new_sentence)
    text_results = float(model.predict(new_sentence))
    print(f"감정 분석 결과 (0 부정 1긍정) : {text_results:.2f}\n")
    return text_results
