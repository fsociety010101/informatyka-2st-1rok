package Chain_2;

public class Dorosli extends GrupaWiekowa{
    public Dorosli(GrupaWiekowa grupaWiekowa) {
        super(grupaWiekowa);
    }

    @Override
    public void podwyzsz(Tancerz tancerz) {


        if(tancerz.getWiek() > 19 && tancerz.getKlasa() == 3 && tancerz.getWynikZawodow().equals(WynikZawodow.SEMI_FINAL)){
            tancerz.setKlasa(4);
        } else if (tancerz.getWynikZawodow().equals(WynikZawodow.QUATER_FINAL) && tancerz.getKlasa()< 3) {
            tancerz.setKlasa(tancerz.getKlasa() + 1);

        }

    }
}
