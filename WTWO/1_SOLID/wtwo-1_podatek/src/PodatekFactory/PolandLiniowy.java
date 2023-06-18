package PodatekFactory;

import Panstwa.Poland;

public class PolandLiniowy implements Poland {
    @Override
    public double getWartoscPodatku(double wartosc) {
        return 0.19 * wartosc;
    }
}
