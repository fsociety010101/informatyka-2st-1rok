package factory;

import java.util.List;

public class DeLorean44 implements DeLorean {
    List<Integer> seats;
    Integer highestTonnage;

    public Boolean isTimeMachine() {
        return false;
    }

    public Boolean works() {
        return false;
    }

    public Integer getSeatsNumber(){
        return seats.size();
    }

    DeLorean44(List<Integer> seats, Integer highestTonnage){
        this.seats = seats;
        this.highestTonnage = highestTonnage;
    }
}
