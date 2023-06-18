package Adapter;

import Main.Magazyn;
import PodatekStrategia.PodatekContext;

public class Adapter {
    Magazyn magazyn;

    public Adapter(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    public Adapter() {
        this.magazyn = new Magazyn();
    }

    public double pobierzWartośćPoOpodatkowaniu(PodatekContext podatekContext, Waluta waluta) {
        double wartosc = this.magazyn.pobierzWartośćPoOpodatkowaniu(podatekContext);

        if (waluta.equals(Waluta.PLN))
            return wartosc * 4.2;
        else if (waluta.equals(Waluta.USD))
            return wartosc / 3 * 3.8;
        return wartosc;
    }
}
