# from text.views import predict
from django.urls import path, include

from reviewcrolling import views

urlpatterns = [
    # path('api/predict/', predict, name='predict'),
    path('face/', include('face.urls')),
    path('calculate/', include('calculate.urls')),
    path('review-crawl/', views.review_crawl, name='review_crawl')
]
