package Przedmioty;

public class Rzezba extends Przedmiot {
    private int rokWykonania;
    private int rozmiar;

    public Rzezba(int rokWykonania, int rozmiar) {
        this.rokWykonania = rokWykonania;
        this.rozmiar = rozmiar;
    }

    @Override
    public double okreslWartosc() {
        return (2020.0 - this.rokWykonania) * this.rozmiar * 2;
    }
}
