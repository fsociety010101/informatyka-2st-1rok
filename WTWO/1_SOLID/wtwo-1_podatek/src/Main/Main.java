package Main;

import Adapter.Adapter;
import Adapter.Waluta;
import PodatekFactory.PodatekFactoryContext;
import PodatekStrategia.PodatekContext;
import PodatekStrategia.PodatekLiniowy;
import PodatekStrategia.PodatekProgresywny;
import Przedmioty.Ksiazka;
import Przedmioty.Obraz;
import Przedmioty.Rzezba;

public class Main {
    public static void main(String[] args) {

        // Część 1
        Magazyn testowyMagazyn = new Magazyn();
        testowyMagazyn.dodajDoSpisu(new Ksiazka(1995));
        testowyMagazyn.dodajDoSpisu(new Rzezba(1543, 15));
        testowyMagazyn.dodajDoSpisu(new Obraz(1772));

        double kwota = testowyMagazyn.obliczKwote();
        System.out.println("bez podatku: " + kwota);

        PodatekContext podatekContext = new PodatekContext(new PodatekLiniowy());
        System.out.println("z podatkiem liniowym: " + String.valueOf(testowyMagazyn.pobierzWartośćPoOpodatkowaniu(podatekContext)));

        podatekContext.setPodatekStrategy(new PodatekProgresywny());
        System.out.println("z podatkiem progresywnym: " + String.valueOf(testowyMagazyn.pobierzWartośćPoOpodatkowaniu(podatekContext)));

        // Część 2
        System.out.println("\ndla krajow liniowe: ");
        PodatekFactoryContext podatekFactoryContext = new PodatekFactoryContext(new PodatekFactory.PodatekLiniowy());
        podatekFactoryContext.createTAX();
        podatekFactoryContext.getFranceTAX(kwota);
        podatekFactoryContext.getGermanyTAX(kwota);
        podatekFactoryContext.getUSATAX(kwota);
        podatekFactoryContext.getPolandTAX(kwota);

        System.out.println("\ndla krajow progresywne: ");
        podatekFactoryContext.setPodatekFactory(new PodatekFactory.PodatekProgresywny());
        podatekFactoryContext.createTAX();
        podatekFactoryContext.getFranceTAX(kwota);
        podatekFactoryContext.getGermanyTAX(kwota);
        podatekFactoryContext.getUSATAX(kwota);
        podatekFactoryContext.getPolandTAX(kwota);

        // Część 3
        System.out.println("\nw roznych walutach: ");
        Adapter adapter = new Adapter(testowyMagazyn);
        System.out.println("EUR: " + String.valueOf(adapter.pobierzWartośćPoOpodatkowaniu(podatekContext, Waluta.EUR)));
        System.out.println("PLN: " + String.valueOf(adapter.pobierzWartośćPoOpodatkowaniu(podatekContext, Waluta.PLN)));
        System.out.println("USD: " + String.valueOf(adapter.pobierzWartośćPoOpodatkowaniu(podatekContext, Waluta.USD)));

    }
}