package Przedmioty;

public class Obraz extends Przedmiot {
    private int rokNamalowania;

    public Obraz(int rokNamalowania) {
        this.rokNamalowania = rokNamalowania;
    }

    @Override
    public double okreslWartosc() {
        return (2100.0 - this.rokNamalowania) * 10.0;
    }
}
