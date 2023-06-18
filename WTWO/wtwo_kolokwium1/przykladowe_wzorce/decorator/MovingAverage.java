package decorator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MovingAverage extends SignalProcessor {
    Integer range;

    MovingAverage(Decorator armament, int range){
        super(armament);
        this.range = range;
    }

    public List<Double> process(List<Double> signal){
        signal = super.process(signal);
        List<Double> processed = new ArrayList<>();
        for (int i = 0; i<signal.size(); i++){
            Double sum = signal.get(i);
            int N = 1;
            if (i - 1 >= 0){
                sum+=signal.get(i-1);
                N++;
            }
            if (i + 1 < signal.size()) {
                sum += signal.get(i + 1);
                N++;
            }
            processed.add(sum/N);
        }
        return processed;
    }
}
