import os


def zadanie1(napis):
    napis = napis.split()
    res = [(i, len(i)) for i in napis]
    return res


def zadanie2_fib(element):
    a, b = 0, 1
    while element:
        element -= 1
        a, b = b, a + b
    return a


def zadanie3_filter(funkcja_logiczna, lista):
    res = []
    for it in lista:
        if funkcja_logiczna(it):
            res.append(it)
    return res


def zadanie4(krotka):
    krotka.sort(key=lambda it: it[1] - it[0])
    return krotka


def find_python_files(file):
    if file.endswith(".py"):
        print(os.path.join(os.getcwd(), file))


def main():
    print(zadanie1("Hello world, it's Python!"))

    # zadanie2 = ( zadanie2_fib(i) for i in range(20) )
    # for a in zadanie2:
    #     print(a)

    # czy_parna = lambda x: x % 2 == 0
    # lista_liczb = [1, 2, 3, 4, 5, 6, 7, 8, 9]
    # print(zadanie3_filter(czy_parna, lista_liczb))

    # krotka = [(1.3, 5.5), (4.1, 4.9), (2.2, 2.5)]
    # print(zadanie4(krotka))

    # zadanie5 = (find_python_files(file) for file in os.listdir(os.getcwd()))
    # for file in zadanie5:
    #     if file is not None:
    #         print(file)


if __name__ == '__main__':
    main()
