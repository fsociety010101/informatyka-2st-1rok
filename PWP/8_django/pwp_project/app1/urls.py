from django.urls import path

from . import views

urlpatterns = [
    path('', views.index),
    path('<slug:slug1>', views.one_argument),
    path('<slug:slug1>/<slug:slug2>/', views.two_arguments),
]
