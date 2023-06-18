package Stan;

public class Przyjety extends Stan {
    Przyjety() {
        System.out.println("Wniosek zostal przyjety!");
    }

    void doAction(Wniosek wniosek, int urzad) {
        if (wniosek.number != urzad) {
            System.out.println("\nPrzekierowujemy...\n");
            wniosek.setStan(new Przekierowany());
        }
    }
}
