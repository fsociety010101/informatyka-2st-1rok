package PodatekFactory;

import Panstwa.France;
import Panstwa.Germany;
import Panstwa.Poland;
import Panstwa.USA;

public class PodatekFactoryContext {
    private PodatekFactory podatekFactory;

    private France france;
    private Germany germany;
    private USA usa;
    private Poland poland;

    public PodatekFactoryContext(PodatekFactory podatekFactory) {
        this.podatekFactory = podatekFactory;
    }

    public void setPodatekFactory(PodatekFactory podatekFactory) {
        this.podatekFactory = podatekFactory;
    }

    public void createTAX() {
        this.france = this.podatekFactory.createPodatekFrance();
        this.germany = this.podatekFactory.createPodatekGermany();
        this.usa = this.podatekFactory.createPodatekUSA();
        this.poland = this.podatekFactory.createPodatekPoland();
    }

    public void getFranceTAX(double wartosc) {
        System.out.println("France:");
        System.out.println(this.france.getWartoscPodatku(wartosc));
    }

    public void getGermanyTAX(double wartosc) {
        System.out.println("Germany:");
        System.out.println(this.germany.getWartoscPodatku(wartosc));
    }

    public void getUSATAX(double wartosc) {
        System.out.println("USA:");
        System.out.println(this.usa.getWartoscPodatku(wartosc));
    }

    public void getPolandTAX(double wartosc) {
        System.out.println("Poland:");
        System.out.println(this.poland.getWartoscPodatku(wartosc));
    }

}
