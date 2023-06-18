from django.db import models
from django.utils import timezone


class Book(models.Model):
    author_name = models.CharField(max_length=200)
    title = models.CharField(max_length=200)
    genre = models.CharField(max_length=200)
    description = models.TextField(default='Description')
    add_date = models.DateTimeField(default=timezone.now)

    def __str__(self):
        return self.title


class Reader(models.Model):
    reader_name = models.CharField(max_length=200)
    book = models.ForeignKey(Book, on_delete=models.CASCADE)

    def __str__(self):
        return self.reader_name


class Borrowing(models.Model):
    borrow_id = models.IntegerField()
    start_date = models.DateTimeField(default=timezone.now)
    end_date = models.DateTimeField(default=timezone.now)
    reader = models.ForeignKey(Reader, on_delete=models.CASCADE)

    def __str__(self):
        return str(self.borrow_id)
