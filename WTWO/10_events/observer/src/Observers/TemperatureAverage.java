package Observers;


import Events.EventChange;
import Events.EventType;

import java.util.ArrayList;

public class TemperatureAverage implements Observer {
    private int position = 0;
    private ArrayList<Double> temperatureLogs = new ArrayList<>(5);

    @Override
    public void update(EventChange change) {
        if (change.getType() == EventType.TEMPERATURE) {
            double temperature = change.getData();
            position %= 5;
            temperatureLogs.add(position, temperature);
        }
    }

    public double getTemperature() {
        double temp = 0.0;
        int counter = 0;

        for (Double d : temperatureLogs) {
            temp += d;
            ++counter;
        }

        return temp / counter;
    }
}
