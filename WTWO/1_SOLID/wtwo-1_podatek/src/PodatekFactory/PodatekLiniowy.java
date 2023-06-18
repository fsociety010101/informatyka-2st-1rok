package PodatekFactory;

import Panstwa.France;
import Panstwa.Germany;
import Panstwa.Poland;
import Panstwa.USA;

public class PodatekLiniowy implements PodatekFactory {
    @Override
    public France createPodatekFrance() {
        return new FranceLiniowy();
    }

    @Override
    public Poland createPodatekPoland() {
        return new PolandLiniowy();
    }

    @Override
    public USA createPodatekUSA() {
        return new USALiniowy();
    }

    @Override
    public Germany createPodatekGermany() {
        return new GermanyLiniowy();
    }
}
