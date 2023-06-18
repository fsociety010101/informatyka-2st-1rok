package Stan_3;

public class FileasFogg extends Podroznik {


    public FileasFogg(Broker broker) {
        super(broker);
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
