package EventBroker.Publishers;

import EventBroker.Events.EventChange;
import EventBroker.Events.EventType;

import java.util.Random;

public class Wind extends Publisher {
    public void createWind() {
        Random random = new Random();
        int speed = random.nextInt(99 + 1); // (max - min + 1) + min [0:99]
        EventChange eventChange = new EventChange(speed, EventType.WIND);
        this.notify(eventChange);
    }
}
