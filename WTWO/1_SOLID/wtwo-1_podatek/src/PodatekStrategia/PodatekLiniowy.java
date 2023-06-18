package PodatekStrategia;

public class PodatekLiniowy implements PodatekStrategy {
    @Override
    public double obliczPodatek(double kwota) {
        return kwota * 0.19;
    }
}
