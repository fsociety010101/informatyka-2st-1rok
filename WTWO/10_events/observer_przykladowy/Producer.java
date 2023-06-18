package observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Producer {

    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer){
        observers.add(observer);
    }

    public void unsubscribe(Observer observer){
        observers.remove(observer);
    }

    public void notify(Article article){
        for(Observer observer: observers){
            observer.update(article);
        }
    }
}
