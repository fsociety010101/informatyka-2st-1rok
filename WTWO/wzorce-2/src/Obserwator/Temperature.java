package Obserwator;

public class Temperature extends Publisher {
    @Override
    public void create_event() {
        TemperatureChange temperatureChange = new TemperatureChange();
        for (Observer subscriber: lista_obserwujacych){
            subscriber.update(temperatureChange);
        }


    }
}
