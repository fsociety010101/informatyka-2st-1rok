package Obserwator;

public class WindChill implements Observer {
    int temperatura_odcz = 0;
    int wind = 0;

    @Override
    public void update(Event event) {
        if (event.getClass() == TemperatureChange.class) {
            temperatura_odcz = ((TemperatureChange) event).temperatura;

        } else {
            this.wind = ((WindChange) event).speed;
            temperatura_odcz = (this.temperatura_odcz - this.wind) / 100;
        }
        System.out.println(temperatura_odcz);
    }
}
