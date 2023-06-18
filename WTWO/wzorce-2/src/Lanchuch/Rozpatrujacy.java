package Lanchuch;

public abstract class Rozpatrujacy {
    Rozpatrujacy rozpatrujacy;

    Rozpatrujacy(Rozpatrujacy rozpatrujacy) {
        this.rozpatrujacy = rozpatrujacy;
    }


    public static void main(String[] args) {
//        Rozpatrujacy rozpatrujacy1 = new Przyjmujacy(new Poprawiajacy(new Analityk(new Archiwista())));
    }

    public void sprawdz(Wniosek wniosek) {
        rozpatrujacy.sprawdz(wniosek);
    }
}
