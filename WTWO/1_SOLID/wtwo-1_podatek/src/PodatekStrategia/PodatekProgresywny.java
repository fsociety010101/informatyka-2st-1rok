package PodatekStrategia;

public class PodatekProgresywny implements PodatekStrategy {
    @Override
    public double obliczPodatek(double kwota) {
        if (kwota <= 10000) {
            return kwota * 0.18;
        } else {
            return kwota * 0.32;
        }
    }
}
