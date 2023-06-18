from os import strerror


def zadanie1():
    napis = '''k1: v1 
            k2: v2 
            k3: v3'''
    napis = napis.split()
    slownik = {}
    for it in range(0, len(napis), 2):
        slownik[napis[it]] = napis[it + 1]
    print(slownik)


def zadanie2(klucz):
    plik = open("../pliki_pomocnicze/test.txt")
    print([line.strip() for line in plik if klucz in line])
    plik.close()


def zadanie3(nazwa, slowo):
    plik = open(nazwa)
    print([line.strip() for line in plik if slowo in line])
    plik.close()


def zadanie4(nazwa):
    plik = open(nazwa)
    data = plik.read()
    print("Ilosc znakow w pliku", nazwa, "=", len(data))


def zadanie5(src, dest):
    try:
        # czytanie danych
        src_file = open(src, 'rb')
        data = bytearray(10)
        src_file.readinto(data)
        src_file.close()

        # zapisywanie danych
        dest_file = open(dest, 'wb')
        dest_file.write(data)
        dest_file.close()

        # sprawdzenie
        print("Skopiowane dane: ")
        bf = open(dest, 'rb')
        data = bytearray(10)
        bf.readinto(data)
        for b in data:
            print(chr(b), end='')
    except IOError as e:
        print("I/O error occured: ", strerror(e.errno))


def main():
    # zadanie1()
    # zadanie2('k2')
    # zadanie3("test.txt", "k4")
    # zadanie4("test.txt")

    # najpierw zapisze dane do pliku zeby skopiowac jego zawartosc do innego
    data = bytearray(10)
    for i in range(len(data)):
        data[i] = ord('a') + i
    bf = open('../pliki_pomocnicze/file1.bin', 'wb')
    bf.write(data)
    bf.close()
    zadanie5("../pliki_pomocnicze/file1.bin", "file2.bin")


if __name__ == "__main__":
    main()
