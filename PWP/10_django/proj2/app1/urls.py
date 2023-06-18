from django.urls import path

from . import views

urlpatterns = [
    path('books', views.books, name='books'),
    path('borrowings', views.borrowings, name='borrowings'),
    path('book_id/', views.book_id, name='book_id'),
    path('book_navigation/', views.book_detail, name='book_detail'),
    path('book_add/', views.book_add, name='book_add'),
]
