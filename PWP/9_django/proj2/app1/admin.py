from django.contrib import admin

from .models import Book, Borrowing, Reader

admin.site.register(Book)
admin.site.register(Reader)
admin.site.register(Borrowing)
