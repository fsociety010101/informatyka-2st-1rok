def zad1():
    l = ['a', 'b', 'c', 'd', 'e', 'a', 'b', 'c', 'd', 'e', 'a', 'b', 'c', 'd', 'e']
    l_new = l[3::3]
    print(l_new)


def zad2():
    pass


def zad3():
    pass


def zad4():
    import sqlite3

    sql_test_table = '''CREATE TABLE IF NOT EXISTS test (

                    id integer,

                    name text,

                    value real
                    )'''

    conn = sqlite3.connect('test.db')
    c = conn.cursor()
    c.execute(sql_test_table)
    conn.commit()
    conn.close()


def zad5():
    import re

    tekst = "To jest test. To jest przykład działania testowych wyrażeń regularnych."
    print(re.findall(r'\bjest\b|\btest\b|\btestowych\b', tekst))


def zad7():
    class A():
        def funkcja(self):
            print("Wywolanie A")

    class B(A):

        def funkcja(self):
            print("Wywolanie B")
            a = A()
            a.funkcja()

    class C(B):
        def funkcja(self):
            print("Wywolanie C")
            b = B()
            b.funkcja()

    kc = C()
    kc.funkcja()


def zad8():
    l = ['a', 'b', 'c', 'd', 'e', 'a', 'b', 'c', 'd', 'e', 'a', 'b', 'c', 'd', 'e']
    l.reverse()
    print(l)


def zad9():
    napis = '\nTestowy\n\n \t\t\t ciąg \r\t znaków\n'
    napis = napis.replace(' ', '_')
    napis = napis.replace('\n', '_')
    napis = napis.replace('\t', '_')
    napis = napis.replace('\r', '_')
    napis = napis.replace('_', ' ')
    napis = napis.split()
    napis = '_'.join(napis)
    print(napis)


def zad10():
    import subprocess

    try:
        subprocess.run(["ech", "Hello World!"], check=True)
    except subprocess.CalledProcessError:
        print('Zdarzył się błąd')


def zad11():
    class MyAdd:
        def __add__(self, other):
            return MyAdd(self.num + other.num)

        def __str__(self):
            return str(self.num)

        def __init__(self, num):
            self.num = num

    print(MyAdd(2) + MyAdd(3))
    print(type(MyAdd(2) + MyAdd(3)))


def zad12():
    class MyException(Exception):
        pass

    try:
        raise MyException('Zdarzył się wyjątek')
    except MyException as ex:
        print(ex)


def zad13():
    def rec_print(l):
        if isinstance(l, list):
            for it in l:
                rec_print(it)
        else:
            print(l)

    l = [1, 2, [31, 32, [331, 332, [3331, 3332, 3333]], 4]]
    for it in l:
        rec_print(it)
