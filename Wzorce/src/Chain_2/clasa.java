package Chain_2;

import java.util.HashMap;

public record clasa() {
    static HashMap<Integer, Klasa> klasy_tancerzy = new HashMap<>();

    public clasa {


    }

    public static HashMap<Integer, Klasa> getKlasy_tancerzy() {
        klasy_tancerzy.put(1,Klasa.C);
        klasy_tancerzy.put(2,Klasa.B);
        klasy_tancerzy.put(3,Klasa.A);
        klasy_tancerzy.put(4,Klasa.S);

        return klasy_tancerzy;
    }
}
