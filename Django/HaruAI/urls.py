# from text.views import predict
from django.urls import path, include

urlpatterns = [
    # path('api/predict/', predict, name='predict'),
    path('face/', include('face.urls')),
]
