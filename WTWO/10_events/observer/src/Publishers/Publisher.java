package Publishers;

import Events.EventChange;
import Observers.Observer;

import java.util.ArrayList;

public class Publisher {
    private ArrayList<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        this.observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        this.observers.remove(observer);
    }

    public void notify(EventChange change) {
        for (Observer observer : this.observers)
            observer.update(change);
    }
}

