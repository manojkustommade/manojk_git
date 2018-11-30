"""Employees URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/1.9/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  url(r'^$', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  url(r'^$', Home.as_view(), name='home')
Including another URLconf
    1. Add an import:  from blog import urls as blog_urls
    2. Import the include() function: from django.conf.urls import url, include
    3. Add a URL to urlpatterns:  url(r'^blog/', include(blog_urls))
"""
from django.conf.urls import url
from django.contrib import admin
from EmployeePortal import views
# from Employees.EmployeePortal import views

admin.autodiscover()
urlpatterns = [
    
    url(r'^$',views.welcome.as_view(),name='welcome'),
    url(r'^addemployee/$',views.addEmp,name='addEmp'),
    url(r'^viewemployee/$',views.viewEmp,name='viewEmployee'),
    url(r'^updateemployeedet/$',views.update,name="update"),
    url(r'^deleteemployee/(?P<data_id>[a-zA-Z0-9]+)/$',views.deleteEmp,name='deleteEmployee'),
    url(r'^updateemployee/(?P<data_id>[a-zA-Z0-9]+)/$',views.updateEmp,name='updateEmployee'),
    url(r'^searchform/$',views.searchdata,name='searchform'),
    url(r'^searchcontent/$',views.searchcontent,name='searchcontent'),
    url(r'^downloadform/$',views.downloadform,name='downloadform'),
    url(r'^uploadform/$',views.uploadform,name='uploadform'),
    url(r'^admin/', admin.site.urls),
]
