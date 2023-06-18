package factory;

import java.util.List;

public class DeLorean80 implements DeLorean {

    List<Integer> seats;

    public Boolean isTimeMachine() {
        return false;
    }

    public Boolean works() {
        return false;
    }

    public Integer getSeatsNumber(){
        return seats.size();
    }

    DeLorean80(List<Integer> seats){
        this.seats = seats;
    }
}
