package Obserwator;

import java.util.ArrayList;
import java.util.List;

public  abstract class Publisher {
    List<Observer> lista_obserwujacych = new ArrayList<>();

    public void create_event(){

    }

    public void subscribe(Observer observer){
        lista_obserwujacych.add(observer);
    }
    public void unsubscribe(Observer observer){
        lista_obserwujacych.remove(observer);
    }
}
