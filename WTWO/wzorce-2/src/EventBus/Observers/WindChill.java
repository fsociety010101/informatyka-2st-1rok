package EventBus.Observers;

import EventBus.Events.EventChange;
import EventBus.Events.EventType;

public class WindChill implements Observer {
    private double wind = 0;
    private double realFeelTemperature = 0;

    @Override
    public void update(EventChange change) {
        if (change.getType() == EventType.WIND)
            wind = change.getData();
        if (change.getType() == EventType.TEMPERATURE) {
            double currTemp = change.getData();
            realFeelTemperature = currTemp - calculateDiff();
        }
    }

    private double calculateDiff() {
        return wind / 100 * 5;
    }

    public double getWindSpeed() {
        return wind;
    }

    public double getRealFeelTemperature() {
        return realFeelTemperature;
    }
}
