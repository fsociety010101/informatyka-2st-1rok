package decorator;

import java.util.*;
import java.math.*;

public class Normalizer extends SignalProcessor {

    Double maxValue;

    Normalizer(Decorator processor, Double maxValue){
        super(processor);
        this.maxValue = maxValue;
    }

    public List<Double> process(List<Double> signal){
        signal = super.process(signal);
        List<Double> abses = new ArrayList<>();
        for (Double a: signal){
            abses.add(Math.abs(a));
        }
        Double max = Collections.max(abses);
        List<Double> processed = new ArrayList<>();
        for (Double sg: signal){
            processed.add(sg*(maxValue/max));
        }
        return processed;
    }
}
