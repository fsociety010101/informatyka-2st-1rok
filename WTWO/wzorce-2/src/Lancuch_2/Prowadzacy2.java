package Lancuch_2;

import java.util.Random;

public class Prowadzacy2 extends Prowadzacy {
    Prowadzacy2(Prowadzacy prowadzacy) {
        super(prowadzacy);
    }

    @Override
    public void sprawdz(int numerZadania) {
        Random random = new Random();
        if (numerZadania == 3) this.oceny.put(3, random.nextInt(10));
        super.sprawdz(numerZadania);
    }
}
