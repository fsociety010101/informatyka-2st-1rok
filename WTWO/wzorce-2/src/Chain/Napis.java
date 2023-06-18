package Chain;

public class Napis {
    String napis;
    Stan stan;

    public String getNapis() {
        return napis;
    }

    public void setNapis(String napis) {
        this.napis = napis;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    public Napis(String napis) {
        this.napis = napis;
        this.stan = Stan.randomValue();
    }
}
