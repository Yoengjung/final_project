from django.http import JsonResponse, HttpResponse
import tensorflow as tf
import cv2
import numpy as np
from django.views.decorators.csrf import csrf_exempt
import matplotlib
import matplotlib.pyplot as plt
from deepface import DeepFace
import tensorflow as tf
from tensorflow.keras.applications import EmotionNet
import cv2
import pandas as pd

matplotlib.use('Agg')
plt.switch_backend('agg')


# Create your views here.

@csrf_exempt
def sendImg(request):
    img = request.FILES['img']
    img = np.frombuffer(img.read(), np.uint8)
    img = cv2.imdecode(img, cv2.IMREAD_COLOR)
    try:
        img = getFace(img)
    except:
        return HttpResponse("Face not found", status=400)
    # img = resizeImg(img)

    if img is None:
        # 얼굴을 찾지 못했을 경우 적절한 응답을 반환하거나 예외 처리를 수행할 수 있습니다.
        return HttpResponse("Face not found", status=400)
    predict_emote(img)
    try:
        # Ensure that img is a numpy array
        img = np.array(img)
        _, buffer = cv2.imencode('.png', img)
        return HttpResponse(buffer.tobytes(), content_type='image/png')
    except cv2.error as e:
        # 예외 처리: 이미지 인코딩 중 문제가 발생했을 경우
        return HttpResponse(f"Image encoding error: {str(e)}", status=500)


def getFace(img):
    # 안면 추출 (detectFace 대신 extract_faces 사용)
    result = DeepFace.extract_faces(img, detector_backend='ssd')[0]

    # 검출된 안면 좌표 가져오기
    facial_area = result['facial_area']
    print("Facial Area:", facial_area)

    # 검출된 안면 좌표를 정수로 변환
    x, y, w, h = map(int, (facial_area['x'], facial_area['y'], facial_area['w'], facial_area['h']))

    # 이미지에서 안면 부분 자르기
    face_img = img[y:y + h, x:x + w]

    return face_img


def resizeImg(img):
    img_array = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
    img_array = cv2.resize(img_array, (224, 224), interpolation=cv2.INTER_AREA)
    return img_array


def predict_emote(img):
    # 모델 불러오기
    model = MobileNetV3(weights="mobilenet_v3_small_100_224", include_top=True)

    # 표정 분류 클래스
    class_names = ["angry", "disgusted", "fearful", "happy", "sad", "surprised", "neutral"]

    # Resize image to match the input size of the VGGFace2 model
    img_array = cv2.resize(img_array, (224, 224))
    img = img_to_array(img)
    img = preprocess_input(img)

    # 모델 예측
    prediction = model.predict(img)

    # 가장 높은 확률을 가진 분류
    class_index = tf.argmax(prediction)

    # 분류 이름 출력
    print(class_names[class_index])
