from django.utils import timezone

from django import forms


class BookForm(forms.Form):
    book_id = forms.IntegerField(label='Book Id')


class BookAddForm(forms.Form):
    book_id = forms.IntegerField(label='Book Id')
    author_name = forms.CharField(label='Author Name')
    title = forms.CharField(label='Title')
    genre = forms.CharField(label='Genre')
    description = forms.CharField(label='Description')
    add_date = forms.DateTimeField(label='Add Date', initial=timezone.now)
