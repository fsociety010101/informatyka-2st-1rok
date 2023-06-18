package decorator;


import java.util.List;
import java.util.Optional;

public abstract class SignalProcessor implements Decorator {

    private Optional<Decorator> armament;

    SignalProcessor(Decorator armament){
        this.armament = Optional.ofNullable(armament);
    }

    public List<Double> process(final List<Double> signal) {
        if (armament.isPresent()){
            return armament.get().process(signal);
        }
        return signal;
    }
}
