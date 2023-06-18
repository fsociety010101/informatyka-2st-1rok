package Stan;

import java.util.ArrayList;
import java.util.HashMap;

public class Broker {
    HashMap<EventType, ArrayList<Subscriber>> lista_obs = new HashMap<EventType, ArrayList<Subscriber>>();
    HashMap<EventType, ArrayList<Publisher>> lista_pub =new HashMap<EventType, ArrayList<Publisher>>();
    public void fire(Publisher publisher, EventType eventType){
        for(Subscriber subscriber: lista_obs.get(eventType)){
            subscriber.call();
        }
    }
    public void register(EventType eventType, Subscriber subscriber){
        if(lista_obs.containsKey(eventType)) {
            this.lista_obs.get(eventType).add(subscriber);

        }else{
            ArrayList<Subscriber> list = new ArrayList<Subscriber>();
            list.add(subscriber);
            lista_obs.put(eventType, list);
        }
    }

}
