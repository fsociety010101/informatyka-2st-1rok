package PodatekFactory;

import Panstwa.France;
import Panstwa.Germany;
import Panstwa.Poland;
import Panstwa.USA;

public class PodatekProgresywny implements PodatekFactory {
    @Override
    public France createPodatekFrance() {
        return new FranceProgresywny();
    }

    @Override
    public Poland createPodatekPoland() {
        return new PolandProgresywny();
    }

    @Override
    public USA createPodatekUSA() {
        return new USAProgresywny();
    }

    @Override
    public Germany createPodatekGermany() {
        return new GermanyProgresywny();
    }
}
