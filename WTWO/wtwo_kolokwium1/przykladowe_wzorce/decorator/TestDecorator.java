package decorator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestDecorator {

    @Test
    void testShift(){
        //given
        Decorator dc = new Shifter(null, -5.0);

        List<Double> signal =  Arrays.asList(0.0,1.0,2.0,3.0,4.0,5.0,6.0);

        //when
        List<Double> prosig = dc.process(signal);

        //then
        assertEquals(-5.0, prosig.get(0));
    }


    @Test
    void testShiftNorm(){
        //given
        Decorator dc = new Shifter(null, -5.0);
        dc = new Normalizer(dc, 10.0);

        List<Double> signal =  Arrays.asList(0.0,1.0,2.0,3.0,4.0,5.0,6.0);

        //when
        List<Double> prosig = dc.process(signal);

        //then
        assertEquals((10.0/5.0)*-5.0, prosig.get(0));
    }


    @Test
    void testShiftNormAvg(){
        //given
        Decorator dc = new Shifter(null, -5.0);
        dc = new Normalizer(dc, 10.0);
        dc = new MovingAverage(dc, 3);

        List<Double> signal =  Arrays.asList(0.0,1.0,2.0,3.0,4.0,5.0,6.0);

        //when
        List<Double> prosig = dc.process(signal);

        //then
        assertEquals(-9.0, prosig.get(0));
    }
}
