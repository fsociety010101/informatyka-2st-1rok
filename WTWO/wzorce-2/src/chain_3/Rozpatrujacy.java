package chain_3;

public abstract class Rozpatrujacy {
    Rozpatrujacy rozpatrujacy;

    public Rozpatrujacy(Rozpatrujacy rozpatrujacy) {
        this.rozpatrujacy = rozpatrujacy;
    }
    public void rozpatrz(){
        rozpatrujacy.rozpatrz();
    }

}
