import re


class MyException(Exception):
    pass


class Email:
    def check(self):
        if re.search("^[^\s;]+@[^\s;]+\.[^\s;]+(?:;[^\s;]+@[^\s;]+\.[^\s;]+)*$", self.email):
            print("This is an email: ", self.email)
        else:
            try:
                raise MyException('This is not an email: ', self.email)
            except MyException as ex:
                print(ex)

    def __init__(self, email):
        self.email = email
        self.check()


def main():
    email = input("Enter email: ")
    test = Email(email)


if __name__ == "__main__":
    main()
