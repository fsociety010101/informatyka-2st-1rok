package Stan_3;

public class Ameryka extends Stan{

    @Override
    public void goNext(Podroznik podroznik) {
        if(podroznik.getMiasto().equals("San Fransisco")){
            podroznik.setMiasto("Nowy York");
            podroznik.broker.fire(podroznik, EventType.ZMIANA_MIASTA);
        }else{
            podroznik.setMiasto("Liverpool");
            podroznik.setStan(new Europa());
            podroznik.broker.fire(podroznik, EventType.ZMIANA_KONTYNENTU);
        }


    }
}


