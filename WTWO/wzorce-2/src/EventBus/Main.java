package EventBus;

import EventBus.Observers.TemperatureAverage;
import EventBus.Observers.WindChill;
import EventBus.Publishers.Temperature;
import EventBus.Publishers.Wind;

import java.util.Timer;
import java.util.TimerTask;


public class Main {
    public static void main(String[] args) {
        // Observators
        TemperatureAverage temperatureAverage = new TemperatureAverage();
        WindChill windChill = new WindChill();

        // Publishers
        Temperature temperature = new Temperature();
        Wind wind = new Wind();

        // Subscribe
//        temperature.subscribe(temperatureAverage);
//        temperature.subscribe(windChill);
//        wind.subscribe(windChill);
//
//        // Tests
//        Timer timer = new Timer();
//        timer.schedule(new GenerateWeather(), 0, 1000);
////        for (int i = 0; i < 100; ++i) {
//
//        }

        class GenerateWeather extends TimerTask {
            public void run() {
                temperature.createTemperature();
                System.out.format("TEMP AVG: %.2f °C\n", temperatureAverage.getTemperature());

                wind.createWind();
                System.out.println("WIND: " + windChill.getWindSpeed() + " m/s");
                System.out.println("REAL FEEL TEMP: " + windChill.getRealFeelTemperature() + " °C");

                System.out.println("\n\n");
            }
        }
    }

//    class GenerateWeather() extends TimerTask
}