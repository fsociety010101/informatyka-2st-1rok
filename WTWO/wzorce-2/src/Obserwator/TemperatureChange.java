package Obserwator;

import java.util.Random;

public class TemperatureChange extends Event{
    int temperatura;

    public TemperatureChange() {
        Random random = new Random();
        this.temperatura = random.nextInt(30 - (-30) + 1) - 30;
    }
}
