from django.http import HttpResponse


def index(request):
    response = '<h1>app2 page</h1>'
    return HttpResponse(response)


def one_argument(request, arg1):
    response = '<h1>app2 page</h1>'
    response += '<p>var1 = ' + arg1 + '</p>'
    return HttpResponse(response)


def two_arguments(request, arg1, arg2):
    response = '<h1>app2 page</h1>'
    response += '<p>var1 = ' + arg1 + '</p>'
    response += '<p>var2 = ' + arg2 + '</p>'
    return HttpResponse(response)


def three_arguments(request, arg1, arg2, arg3):
    response = '<h1>app2 page</h1>'
    response += '<p>var1 = ' + arg1 + '</p>'
    response += '<p>var2 = ' + arg2 + '</p>'
    response += '<p>var3 = ' + arg3 + '</p>'
    return HttpResponse(response)
