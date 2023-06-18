class AuntyEntity:
    __builder = None

    def __init__(self, m_osoby, m_wieze_straznicze):
        self._m_osoby = m_osoby
        self._m_wieze_straznicze = m_wieze_straznicze

    def set_builder(self, builder):
        self.__builder = builder

    def get_kopula_gromu(self):
        kopula_gromu = KopulaGromu()

        # Budowanie wiezenia
        wiezienie = self.__builder.produce_wiezenie(self._m_osoby)
        kopula_gromu.set_wiezienie(wiezienie)

        # Budowanie rafinerii
        rafineria = self.__builder.produce_rafineria()
        kopula_gromu.set_rafineria(rafineria)

        # Budowanie studni
        studnia = self.__builder.produce_studnia()
        kopula_gromu.set_studnia(studnia)

        # Budowanie wiez strazniczych
        i = 0
        while i < self._m_wieze_straznicze:
            wieza = self.__builder.produce_wieza_straznicza("Wieza nr " + str(i))
            kopula_gromu.set_wieze_straznicze(wieza)
            i += 1

        return kopula_gromu


class KopulaGromu:
    def __init__(self):
        self.__wiezienie = None
        self.__rafineria = None
        self.__studnia = None
        self.__wieze_straznicze = list()

    def set_wiezienie(self, wiezienie):
        self.__wiezienie = wiezienie

    def set_rafineria(self, rafineria):
        self.__rafineria = rafineria

    def set_studnia(self, studnia):
        self.__studnia = studnia

    def set_wieze_straznicze(self, wieza_straznicza):
        self.__wieze_straznicze.append(wieza_straznicza)

    def specification(self):
        print("Wiezienie: ", self.__wiezienie.opis)
        print("Rafineria :", self.__rafineria.opis)
        print("Studnia: ", self.__studnia.opis)
        for it in self.__wieze_straznicze:
            print(it.opis)


class Wiezienie:
    opis = None
    pojemnosc = None


class Rafineria:
    opis = None


class Studnia:
    opis = None


class WiezaStraznicza:
    opis = None


class Builder:
    def produce_wiezenie(self) -> Wiezienie:
        pass

    def produce_rafineria(self) -> Rafineria:
        pass

    def produce_studnia(self) -> Studnia:
        pass

    def produce_wieza_straznicza(self) -> WiezaStraznicza:
        pass


class KopulaGromuBuilder(Builder):
    def produce_wiezenie(self, ilosc_osob) -> Wiezienie:
        wiezenie = Wiezienie()
        wiezenie.opis = "Wiezenie o pojemnosci " + str(ilosc_osob) + " osob."
        return wiezenie

    def produce_rafineria(self) -> Rafineria:
        rafineria = Rafineria()
        rafineria.opis = "Rafineria"
        return rafineria

    def produce_studnia(self) -> Studnia:
        studnia = Studnia()
        studnia.opis = "Studnia"
        return studnia

    def produce_wieza_straznicza(self, str) -> WiezaStraznicza:
        wieza_straznicza = WiezaStraznicza()
        wieza_straznicza.opis = str
        return wieza_straznicza


def main():
    kopula_gromu_builder = KopulaGromuBuilder()  # initializing the class

    director = AuntyEntity(25, 6)

    director.set_builder(kopula_gromu_builder)
    kopula_gromu = director.get_kopula_gromu()
    kopula_gromu.specification()


if __name__ == "__main__":
    main()
