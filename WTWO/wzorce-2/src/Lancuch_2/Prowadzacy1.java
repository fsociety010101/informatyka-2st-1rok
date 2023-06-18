package Lancuch_2;

import java.util.Random;

public class Prowadzacy1 extends Prowadzacy {
    Prowadzacy1(Prowadzacy prowadzacy) {
        super(prowadzacy);
    }

    @Override
    public void sprawdz(int numerZadania) {
        Random random = new Random();
        if (numerZadania == 2) this.oceny.put(2, random.nextInt(8));
        if (numerZadania == 4) this.oceny.put(4, random.nextInt(9));
        super.sprawdz(numerZadania);
    }
}
