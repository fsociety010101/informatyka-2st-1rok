package PodatekFactory;

import Panstwa.France;
import Panstwa.Poland;
import Panstwa.USA;
import Panstwa.Germany;

public interface PodatekFactory {
    France createPodatekFrance();

    Poland createPodatekPoland();

    USA createPodatekUSA();

    Germany createPodatekGermany();
}
