package Stan;

public class Wniosek {
    Stan stan;

    int number;

    public Wniosek(int number) {
        this.stan = new Zlozony();
        this.number = number;
    }

    public static void main(String[] args) {
        Wniosek wniosek = new Wniosek(1);
        wniosek.sprawdz(2);
        wniosek.sprawdz(3);
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    void sprawdz(int number) {
        this.stan.doAction(this, number);
    }
}
