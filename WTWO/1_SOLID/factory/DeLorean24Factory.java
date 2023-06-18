package factory;

import java.util.ArrayList;
import java.util.List;

public class DeLorean24Factory implements DeLoreanFactory {

    public DeLorean createDeLorean() {
        List<Integer> seats = new ArrayList<Integer>();
        for (int i = 0; i<4 ;i++)
            seats.add(i);
        return new DeLorean24(seats);
    }
}
