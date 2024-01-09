from django.db import models
# text/models.py
from django.db import models

class TextData(models.Model):
    content = models.TextField()  # 분석할 텍스트 필드

    def __str__(self):
        return self.content[:50]  # 객체를 문자열로 표현할 때 텍스트의 처음 50자를 반환

# Create your models here.
