from abc import ABC, abstractmethod


class Creator(ABC):
    """
    The Creator class declares the factory method that is supposed to return an
    object of a Product class. The Creator's subclasses usually provide the
    implementation of this method.
    """

    @abstractmethod
    def factory_method(self):
        pass

    def translate(self, word) -> str:
        # Call the factory method to create a Product object.
        product = self.factory_method()

        # Now, use the product.
        result = f"Creator: Translation of {word} is {product.translate(word)}"

        return result


class Language(ABC):
    """
    The Product interface declares the operations that all concrete products
    must implement.
    """

    @abstractmethod
    def translate(self, word) -> str:
        pass


class EnglishFactory(Creator):
    def factory_method(self) -> Language:
        return EnglishLocalizer()


class FrenchFactory(Creator):
    def factory_method(self) -> Language:
        return FrenchLocalizer()


class SpanishFactory(Creator):
    def factory_method(self) -> Language:
        return SpanishLocalizer()


class FrenchLocalizer(Language):
    def __init__(self):
        self.translations = {"car": "voiture", "bike": "bicyclette",
                             "cycle": "cyclette"}

    def translate(self, word) -> str:
        print("{Result of the FrenchLocalizer}")
        return self.translations.get(word, word)


class SpanishLocalizer(Language):
    def __init__(self):
        self.translations = {"car": "coche", "bike": "bicicleta",
                             "cycle": "ciclo"}

    def translate(self, word):
        print("{Result of the SpanishLocalizer}")
        return self.translations.get(word, word)


class EnglishLocalizer(Language):
    def translate(self, word):
        print("{Result of the EnglishLocalizer}")
        return word


if __name__ == "__main__":
    eng = EnglishFactory()
    esp = SpanishFactory()
    fr = FrenchFactory()

    words = ["car", "bike", "cycle"]
    #
    for word in words:
        print(eng.translate(word))
        print(esp.translate(word))
        print(fr.translate(word) + "\n")
