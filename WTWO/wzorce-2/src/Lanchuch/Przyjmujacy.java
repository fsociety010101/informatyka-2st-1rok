package Lanchuch;

public class Przyjmujacy extends Rozpatrujacy {
    Przyjmujacy(Rozpatrujacy rozpatrujacy) {
        super(rozpatrujacy);
    }

    @Override
    public void sprawdz(Wniosek wniosek) {
        if (wniosek.stan.getClass().equals(Zlozony.class)) {
            wniosek.setStan(new Przyjety());
        }
        super.sprawdz(wniosek);
    }
}
