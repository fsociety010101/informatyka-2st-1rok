from django.urls import path

from . import views

urlpatterns = [
    path('', views.index),
    path('<slug:arg1>', views.one_argument),
    path('<slug:arg1>/<slug:arg2>/', views.two_arguments),
    path('<slug:arg1>/<slug:arg2>/<slug:arg3>', views.three_arguments),
]
