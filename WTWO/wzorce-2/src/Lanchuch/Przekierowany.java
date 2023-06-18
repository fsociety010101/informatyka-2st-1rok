package Lanchuch;

public class Przekierowany extends Stan {
    Przekierowany() {
        System.out.println("Wniosek zostal przekierowany!");
    }

    void doAction(Wniosek wniosek, int urzad) {
        System.out.println("\nCzekam 1 min...\n");
        wniosek.setStan(new Przyjety());
    }
}
