import re


class NameErrException(Exception):
    """name is not valid"""
    pass


class SurnameErrException(Exception):
    """surname is not valid"""
    pass


class PeselErrException(Exception):
    """pesel is not valid"""
    pass


class PersonErrException(Exception):
    """person creation failure"""
    pass


class Person:
    __name_check = False
    __surname_check = False
    __pesel_check = False

    def display(self):
        print("Name: ", self.__name)
        print("Surname: ", self.__surname)
        print("PESEL: ", self.__pesel)

    def __init__(self, name, surname, pesel):
        # name check
        if re.search("^[a-zA-Z]+", name) is not None:
            self.__name_check = True
        else:
            try:
                raise NameErrException(name, " is not a name!")
            except NameErrException as ex:
                print(ex)

        # surname check
        if re.search("[a-zA-Z]+", surname) is not None:
            self.__surname_check = True
        else:
            try:
                raise SurnameErrException(surname, " is not a surname!")
            except SurnameErrException as ex:
                print(ex)

        # pesel check
        if re.search("[0-9]{11}", pesel) is not None:
            self.__pesel_check = True
        else:
            try:
                raise PeselErrException(pesel, " is not a name!")
            except PeselErrException as ex:
                print(ex)

        # check if it is possible to create a person class
        if self.__name_check and self.__surname_check and self.__pesel_check:
            self.__name = name
            self.__surname = surname
            self.__pesel = pesel
            self.display()
        else:
            try:
                raise PersonErrException("Cannot create a Person!")
            except PersonErrException as ex:
                print(ex)


def main():
    test = Person("Jan", "Kowalski", "01234567890")


if __name__ == "__main__":
    main()
