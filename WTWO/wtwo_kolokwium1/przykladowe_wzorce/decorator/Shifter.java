package decorator;

import java.util.ArrayList;
import java.util.List;

public class Shifter extends SignalProcessor {
    Double shift;

    Shifter(Decorator processor, Double shift){
        super(processor);
        this.shift = shift;
    }

    public List<Double> process(List<Double> signal){
        signal = super.process(signal);
        List<Double> processed = new ArrayList<>();
        for (Double sg : signal){
            processed.add(sg+shift);
        }
        return processed;
    }
}
