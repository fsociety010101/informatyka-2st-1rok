package factory;

import java.util.ArrayList;
import java.util.List;

public class DeLorean12Factory implements DeLoreanFactory {

    public DeLorean createDeLorean() {
        List<Integer> seats = new ArrayList<Integer>();
        for (int i = 0; i<2 ;i++)
            seats.add(i);
        System.out.println(seats.size());
        return new DeLorean12(new FlexCapacitor(), seats);
    }
}
