package PodatekFactory;

import Panstwa.France;

public class FranceProgresywny implements France {

    @Override
    public double getWartoscPodatku(double wartosc) {
        if (wartosc <= 40000) {
            return 0.3 * wartosc;
        } else {
            return 0.5 * wartosc;
        }
    }
}
