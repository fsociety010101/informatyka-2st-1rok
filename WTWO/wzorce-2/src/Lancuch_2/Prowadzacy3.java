package Lancuch_2;

import java.util.Random;

public class Prowadzacy3 extends Prowadzacy {
    Prowadzacy3(Prowadzacy prowadzacy) {
        super(prowadzacy);
    }

    @Override
    public void sprawdz(int numerZadania) {
        Random random = new Random();
        if (numerZadania == 1) this.oceny.put(1, random.nextInt(5));
        if (numerZadania == 5) this.oceny.put(5, random.nextInt(12));
    }
}
