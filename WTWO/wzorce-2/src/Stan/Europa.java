package Stan;

public class Europa extends Stan {


    @Override
    public void goNext(Podroznik podroznik) {
        if(podroznik.miasto.equals("Turyn")){
            podroznik.setMiasto("Bombaj");
            podroznik.setStan(new Azja());
            podroznik.broker.fire(podroznik, EventType.ZMIANA_KONTYNENTU);
        }else if(podroznik.getMiasto().equals("Londyn")){
            podroznik.setMiasto("Turyn");
            podroznik.broker.fire(podroznik, EventType.ZMIANA_MIASTA);
        }else{
            podroznik.setMiasto("Londyn");
            podroznik.broker.fire(podroznik, EventType.ZMIANA_MIASTA);
        }
    }
}
