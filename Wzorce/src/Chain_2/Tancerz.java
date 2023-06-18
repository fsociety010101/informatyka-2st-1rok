package Chain_2;

public class Tancerz {
    int klasa;
    int wiek;
    WynikZawodow wynikZawodow;



    public Tancerz(int klasa, int wiek, WynikZawodow wynikZawodow) {
        this.klasa = klasa;
        this.wiek = wiek;
        this.wynikZawodow = wynikZawodow;
    }

    public WynikZawodow getWynikZawodow() {
        return wynikZawodow;
    }

    public void setWynikZawodow(WynikZawodow wynikZawodow) {
        this.wynikZawodow = wynikZawodow;

}
    public int getWiek() {
        return wiek;
    }

    public void setWiek(int wiek) {
        this.wiek = wiek;
    }

    public int  getKlasa() {
        return klasa;
    }

    public void setKlasa(int klasa ) {
        this.klasa = klasa;
    }
}
