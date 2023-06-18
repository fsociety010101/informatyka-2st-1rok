package PodatekFactory;

import Panstwa.USA;

public class USAProgresywny implements USA {
    @Override
    public double getWartoscPodatku(double wartosc) {
        return 0.1 * wartosc;
    }
}
