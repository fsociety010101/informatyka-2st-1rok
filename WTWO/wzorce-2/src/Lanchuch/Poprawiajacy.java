package Lanchuch;

public class Poprawiajacy extends Rozpatrujacy {
    Poprawiajacy(Rozpatrujacy rozpatrujacy) {
        super(rozpatrujacy);
    }

    @Override
    public void sprawdz(Wniosek wniosek) {
        if (wniosek.stan.getClass().equals(Przekierowany.class)) {
            wniosek.setStan(new Przyjety());
        }
        super.sprawdz(wniosek);
    }
}
