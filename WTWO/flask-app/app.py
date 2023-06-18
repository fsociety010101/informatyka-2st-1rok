import requests
from flask import Flask
from flask_restful import  Resource, Api, reqparse
from flask_serialize import FlaskSerialize


app = Flask(__name__)
api = Api(app)
fs_mixin = FlaskSerialize()




class Ksiazka(fs_mixin, Resource):
    def __init__(self, autor, tytul, nr_katalogu):
        self.autor = autor
        self.tytul = tytul
        self.nr_katalogu = nr_katalogu

    def __str__(self):
        return {"autor:": self.autor, "tytul: ": self.tytul, "numer katalogu:" :self.nr_katalogu }

class Ksiazki(Resource):
    tablica_ksiazek = []

    def add(self, ksiazka):
        self.tablica_ksiazek.append(ksiazka)

    def get(self):

        return {'data':self.tablica_ksiazek}
    def put(self, nazwa_ksiazki, nowa_nazwa ):
        for x in self.tablica_ksiazek:
            if x["autor"] == nazwa_ksiazki:
                x["autor"] = nowa_nazwa



lista_ksiazek = Ksiazki()

ksiazka = Ksiazka("Adam Mickiewicz", "Dziady", "2000")
ksiazka_1 = Ksiazka("Henryk Sienkiewicz", "Potop", "3000")
lista_ksiazek.add(ksiazka.__str__())
lista_ksiazek.add(ksiazka_1.__str__())

api.add_resource(Ksiazki, '/ksiazki')




if __name__ == '__main__':
    app.run()
    print(requests.get("http://127.0.0.1:5000/ksiazki", verify=False).request)

    print("a")