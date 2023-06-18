package Main;

import PodatekStrategia.PodatekContext;
import Przedmioty.Przedmiot;

import java.util.ArrayList;

public class Magazyn {
    private ArrayList<Przedmiot> przedmioty;

    public Magazyn() {
        this.przedmioty = new ArrayList<Przedmiot>();
    }

    public void dodajDoSpisu(Przedmiot przedmiot) {
        przedmioty.add(przedmiot);
    }

    public double obliczKwote() {
        double kwota = 0;

        for (Przedmiot przedmiot : przedmioty)
            kwota += przedmiot.okreslWartosc();

        return kwota;
    }

    public double pobierzWartośćPoOpodatkowaniu(PodatekContext podatekContext) {
        double kwota = obliczKwote();

        return podatekContext.obliczPodatek(kwota);
    }
}
