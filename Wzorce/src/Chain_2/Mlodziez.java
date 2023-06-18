package Chain_2;

public class Mlodziez extends GrupaWiekowa{
    public Mlodziez(GrupaWiekowa grupaWiekowa) {
        super(grupaWiekowa);
    }

    @Override
    public void podwyzsz(Tancerz tancerz) {

        if(tancerz.getWiek()>=16 && tancerz.getWiek()<=18 && tancerz.getWynikZawodow().equals(WynikZawodow.FINAL) && tancerz.getKlasa() < 4 && tancerz.getKlasa() ==3){
            tancerz.setKlasa(4);

        }else{
            super.podwyzsz(tancerz);
        }
    }

    }
