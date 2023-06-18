from django.shortcuts import render

from .models import Book, Borrowing


def books(request):
    books_list = Book.objects.all()
    return render(request, 'books.html', {"books": books_list})


def borrowings(request):
    borrowings_list = Borrowing.objects.all()
    return render(request, 'borrowings.html', {"borrowings": borrowings_list})
