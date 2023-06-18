package EventBus.Publishers;

import EventBus.Events.EventChange;
import EventBus.Events.EventType;

import java.util.Random;

public class Temperature extends Publisher {
    public void createTemperature() {
        Random random = new Random();
        int temperature = random.nextInt(30 - (-30) + 1) - 30; // (max - min + 1) + min [-30:30]
        EventChange eventChange = new EventChange(temperature, EventType.TEMPERATURE);
        this.notify(eventChange);
    }
}
