package PodatekStrategia;

public class PodatekContext {
    PodatekStrategy podatekStrategy;

    public PodatekContext(PodatekStrategy podatekStrategy) {
        this.podatekStrategy = podatekStrategy;
    }

    public void setPodatekStrategy(PodatekStrategy podatekStrategy) {
        this.podatekStrategy = podatekStrategy;
    }

    public double obliczPodatek(double kwota) {
        return this.podatekStrategy.obliczPodatek(kwota);
    }
}
