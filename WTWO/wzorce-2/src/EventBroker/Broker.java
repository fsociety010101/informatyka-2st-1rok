package EventBroker;

import EventBus.Events.EventType;
import EventBus.Observers.Observer;

import java.util.HashMap;
import java.util.List;

public class Broker {
    HashMap<EventType, List<Observer>> mapa = new HashMap<>();

}
