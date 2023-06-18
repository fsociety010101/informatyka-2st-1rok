from django.http import HttpResponse


def index(request):
    response = '<h1>app1 page</h1>'
    return HttpResponse(response)


def one_argument(request, slug1):
    response = '<h1>app1 page</h1>'
    response += '<p>Arg1: ' + slug1 + '</p>'
    return HttpResponse(response)


def two_arguments(request, slug1, slug2):
    response = '<h1>app1 page</h1>'
    response += '<p>Arg1: ' + slug1 + '</p>'
    response += '<p>Arg2: ' + slug2 + '</p>'
    return HttpResponse(response)
