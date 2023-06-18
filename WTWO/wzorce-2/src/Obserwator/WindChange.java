package Obserwator;

import java.util.Random;

public class WindChange extends Event{
    int speed;

    public WindChange() {
        Random random = new Random();
        this.speed = random.nextInt(0,99);;
    }
}
