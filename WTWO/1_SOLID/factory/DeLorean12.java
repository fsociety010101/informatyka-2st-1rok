package factory;

import java.util.ArrayList;
import java.util.List;

public class DeLorean12 implements DeLorean {
    FlexCapacitor flexCapacitor;
    List<Integer> seats;

    public Boolean isTimeMachine() {
        return true;
    }

    public Boolean works(){
        return true;
    }

    public Integer getSeatsNumber(){
        return seats.size();
    }

    DeLorean12(FlexCapacitor flexCapacitor, List<Integer> seats){
        this.flexCapacitor = flexCapacitor;
        this.seats = seats;
    }
}
