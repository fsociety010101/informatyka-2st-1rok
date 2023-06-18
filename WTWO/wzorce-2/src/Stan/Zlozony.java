package Stan;

public class Zlozony extends Stan {
    Zlozony() {
        System.out.println("Wniosek zostal zlozony!");
    }

    void doAction(Wniosek wniosek, int urzad) {
        System.out.println("\nCzekam 1 min...\n");
        wniosek.setStan(new Przyjety());
    }
}
