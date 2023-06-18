from abc import ABC, abstractmethod


class Magazyn:
    def dodajDoSpisu(self, przedmiot):
        pass

    def pobierzWartoscPoOpodatkowaniu(self, podatek):
        pass

    def okreslWartosc(self):
        pass


class Przedmiot(ABC):
    @abstractmethod
    def execute(self) -> str:
        pass

    def okreslWartosc(self):
        pass


class Ksiazki(Przedmiot):
    pass


class Obrazy(Przedmiot):
    pass


class Rzezby(Przedmiot):
    pass


def main():
    obj1 = Ksiazki()
    obj1


if __name__ == '__main__':
    main()
