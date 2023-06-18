package Lancuch_2;

import java.util.HashMap;
import java.util.Map;

public abstract class Prowadzacy {
    Prowadzacy prowadzacy;

    HashMap<Integer, Integer> oceny = new HashMap<>();

    Prowadzacy(Prowadzacy prowadzacy) {
        this.prowadzacy = prowadzacy;
    }

    public static void main(String[] args) {
        Prowadzacy1 p1 = new Prowadzacy1(new Prowadzacy2(new Prowadzacy3(null)));
        p1.sprawdz(1);
        p1.sprawdz(2);
        p1.sprawdz(3);
        p1.sprawdz(4);
        p1.sprawdz(5);

        p1.srednia();
    }

    public void sprawdz(int numerZadania) {
        this.prowadzacy.sprawdz(numerZadania);
    }

    public void srednia() {
        int srednia = 0;
        for (Map.Entry<Integer, Integer> it : oceny.entrySet())
            srednia += it.getValue();
        srednia = srednia / oceny.size();
        System.out.println("Srednia = " + srednia);
    }
}
