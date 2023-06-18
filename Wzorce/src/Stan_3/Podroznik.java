package Stan_3;

public class Podroznik implements Publisher {
    String miasto;
    Stan stan;
    Broker broker;
    public Podroznik(Broker broker) {
        this.miasto = "Londyn";
        this.stan = new Europa();
        this.broker = broker;
    }
    public void goNext(){
        this.stan.goNext(this);
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }
}
