package PodatekFactory;

import Panstwa.France;

public class FranceLiniowy implements France {
    @Override
    public double getWartoscPodatku(double wartosc) {
        return 0.3 * wartosc;
    }
}
