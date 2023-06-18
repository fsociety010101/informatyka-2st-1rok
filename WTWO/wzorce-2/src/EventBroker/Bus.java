package EventBroker;

import EventBroker.Events.EventChange;
import EventBroker.Observers.Observer;

import java.util.ArrayList;
import java.util.List;

public class Bus {
    List<Observer> observers = new ArrayList<>();

    public void fire(EventChange event) {
        for (Observer it : observers) {
            it.update(event);
        }
    }

    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }
}
