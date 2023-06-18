from django.shortcuts import render


def index(request):
    var1 = 'MyVar 1'
    var2 = 'MyVar 2'
    var3 = 'MyVar 3'

    context = {
        'myvar1': var1,
        'myvar2': var2,
        'myvar3': var3,
    }

    return render(request, 'books.html', context=context)
