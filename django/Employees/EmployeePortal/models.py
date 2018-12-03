from __future__ import unicode_literals

from django.db import models

# Create your models here.
class addEmployee(models.Model):
    username=models.CharField(max_length=150)
    email=models.EmailField(max_length=250,unique=True)
    mobilenumber=models.CharField(max_length=10)