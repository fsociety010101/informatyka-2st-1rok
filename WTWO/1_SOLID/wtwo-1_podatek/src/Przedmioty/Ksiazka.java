package Przedmioty;

public class Ksiazka extends Przedmiot {
    private int rokWydania;

    public Ksiazka(int rokWydania) {
        this.rokWydania = rokWydania;
    }

    @Override
    public double okreslWartosc() {
        return 2050.0 - this.rokWydania;
    }
}
