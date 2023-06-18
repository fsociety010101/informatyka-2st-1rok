package PodatekFactory;

import Panstwa.Germany;

public class GermanyProgresywny implements Germany {
    @Override
    public double getWartoscPodatku(double wartosc) {
        if (wartosc <= 50000) {
            return 0.2 * wartosc;
        } else {
            return 0.5 * wartosc;
        }
    }
}
