from django.shortcuts import redirect, render
from django.contrib.auth.forms import UserCreationForm
from django.urls import reverse_lazy
from django.views import generic


class SignUpView(generic.CreateView):
    form_class = UserCreationForm
    success_url = reverse_lazy("login")
    template_name = "registration/signup.html"


def index():
    return redirect("/")


def page1(request):
    return render(request, "../templates/app1/page1.html")


def page2(request):
    return render(request, "../templates/app1/page2.html")
