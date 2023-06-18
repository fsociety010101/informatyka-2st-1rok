package PodatekFactory;

import Panstwa.Poland;

public class PolandProgresywny implements Poland {
    @Override
    public double getWartoscPodatku(double wartosc) {
        if (wartosc <= 10000) {
            return wartosc * 0.18;
        } else {
            return wartosc * 0.32;
        }
    }
}
