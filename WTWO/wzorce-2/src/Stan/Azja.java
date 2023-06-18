package Stan;

public class Azja extends Stan{

    @Override
    public void goNext(Podroznik podroznik) {
        if(podroznik.getMiasto().equals("Bombaj")){
            podroznik.setMiasto("Honkong");
            podroznik.broker.fire(podroznik, EventType.ZMIANA_MIASTA);
        }else{
            podroznik.setStan(new Ameryka());
            podroznik.setMiasto("San Fransisco");
            podroznik.broker.fire(podroznik, EventType.ZMIANA_KONTYNENTU);
        }
    }
}
