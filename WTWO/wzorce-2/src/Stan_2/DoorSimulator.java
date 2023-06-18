package Stan_2;

public class DoorSimulator {
    Stan stan;
    Client client;

    public DoorSimulator(Client client) {
        this.client = client;
    }

    public Stan getStan() {
        return stan;
    }

    public void setStan(Stan stan) {
        this.stan = stan;
    }

    void open(){
        this.stan.open(this);
    }
    void stop(){
        this.stan.stop(this);
    };
    void close(){
        this.stan.close(this);
    };
    void start(){
        this.stan.start(this);
    };
}
