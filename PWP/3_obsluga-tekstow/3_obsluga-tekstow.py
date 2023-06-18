import re


def zadanie1():
    f = open("../pliki_pomocnicze/plik_daty.txt", "r")
    text = f.read()
    f.close()

    my_regex = re.compile("([0-9]{1,2}).(\w+).([0-9]{4})")

    for it in my_regex.finditer(text):
        print(it.group())


def zadanie2():
    f = open("../pliki_pomocnicze/plik_urle.txt", "r")
    text = f.read()
    f.close()

    my_regex = re.compile(
        '(?P<protokol>https?):\/\/(?P<adres>\w+\.[a-z]{1,3}):?(?P<port>[0-9]+)?:?(?P<sciezka>\/[^?]+\.html)?(?P<parametry>\?[^#]+)?(?P<kotwica>#(\w)+)?'
    )

    for it in my_regex.finditer(text):
        print(it.group("protokol"))


def zadanie3():
    f = open("../pliki_pomocnicze/plik_daty.txt", "r")
    text = f.read()
    f.close()


def main():
    # zadanie1()
    zadanie2()
    # zadanie3()


if __name__ == "__main__":
    main()
