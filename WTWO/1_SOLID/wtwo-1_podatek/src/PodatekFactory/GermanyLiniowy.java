package PodatekFactory;

import Panstwa.Germany;

public class GermanyLiniowy implements Germany {
    @Override
    public double getWartoscPodatku(double wartosc) {
        return 0.2 * wartosc;
    }
}
