from django.shortcuts import render

from .forms import BookAddForm, BookForm
from .models import Book, Borrowing


def books(request):
    books_list = Book.objects.all()
    return render(request, "books.html", {"books": books_list})


def borrowings(request):
    borrowings_list = Borrowing.objects.all()
    return render(request, "borrowings.html", {"borrowings": borrowings_list})


def book_id(request):
    msg = ""
    if request.method == "POST":
        form = BookForm(request.POST)
        if form.is_valid():
            book_id = form.cleaned_data["book_id"]
            try:
                onebook = Book.objects.get(id=book_id)
            except:
                msg += "Błąd! book_id=" + str(book_id)
            else:
                msg += onebook.author_name + " " + onebook.title
    else:
        form = BookForm()
        form.fields["book_id"].initial = 1
    return render(request, "book_id.html", {"form": form, "msg": msg})


def book_detail(request):
    msg = ""
    info = []
    if request.method == "POST":
        form = BookForm(request.POST)
        if form.is_valid():
            book_id = form.cleaned_data["book_id"]
            try:
                onebook = Book.objects.get(id=book_id)
            except:
                msg += "Błąd! book_id=" + str(book_id)
                info.append(msg)
            else:
                info.append("Author: " + onebook.author_name)
                info.append("Title: " + onebook.title)
                info.append("Genre: " + onebook.genre)
                info.append("Description: " + onebook.description)
    else:
        form = BookForm()
        form.fields["book_id"].initial = 1
    return render(request, "book_navigation.html", {"form": form, "info": info})


def book_add(request):
    msg = ""
    if request.method == "POST":
        form = BookAddForm(request.POST)
        if form.is_valid():
            book_id = form.cleaned_data["book_id"]
            author_name = form.cleaned_data["author_name"]
            title = form.cleaned_data["title"]
            genre = form.cleaned_data["genre"]
            description = form.cleaned_data["description"]
            add_date = form.cleaned_data["add_date"]

            newbook = Book(
                id=book_id,
                author_name=author_name,
                title=title,
                genre=genre,
                description=description,
                add_date=add_date,
            )

            newbook.save()
            msg += "Dodano książkę: " + str(newbook)
    else:
        form = BookAddForm()
        form.fields["book_id"].initial = 1
        form.fields["author_name"].initial = "Author Name"
        form.fields["title"].initial = "Title"
        form.fields["genre"].initial = "Genre"
        form.fields["description"].initial = "Description"
        form.fields["add_date"].initial = "2020-01-01 00:00:00"
    return render(request, "book_add.html", {"form": form, "msg": msg})
