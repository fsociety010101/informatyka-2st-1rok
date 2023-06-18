import unittest


class KopulaGromu(unittest.TestCase):
    def give_fuel(self, points):
        if points >= 30:
            assert "Osoba otrzymuje zadana ilosc paliwa."
        elif 10 <= points < 30:
            assert "Osoba otrzymuje maksymalnie 10l paliwa i polowe zadanej nadwyzki ponad wspomniane 10l paliwa"


if __name__ == "__main__":
    unittest.main()
