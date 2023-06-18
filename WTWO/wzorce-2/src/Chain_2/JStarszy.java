package Chain_2;

public class JStarszy extends GrupaWiekowa{

    public JStarszy(GrupaWiekowa grupaWiekowa) {
        super(grupaWiekowa);
    }


    @Override
    public void podwyzsz(Tancerz tancerz) {
        if(tancerz.getWiek()>=14 && tancerz.getWiek()<=15 && tancerz.getWynikZawodow().equals(WynikZawodow.FINAL) && tancerz.getKlasa() < 4){
            tancerz.setKlasa(tancerz.getKlasa() + 1);

        }else{
            super.podwyzsz(tancerz);
        }
    }


}
