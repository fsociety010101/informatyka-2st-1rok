package factory;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestFactory {

    @Test
    void testDeLorean12Creation(){
        //given
        DeLoreanFactory factory = new DeLorean12Factory();

        //when
        DeLorean deLorean = factory.createDeLorean();

        //then
        assertTrue(deLorean.isTimeMachine());
        assertEquals(2, deLorean.getSeatsNumber());
        assertTrue(deLorean.works());
    }


    @Test
    void testDeLorean24Creation(){
        //given
        DeLoreanFactory factory = new DeLorean24Factory();

        //when
        DeLorean deLorean = factory.createDeLorean();

        //then
        assertFalse(deLorean.isTimeMachine());
        assertEquals(4, deLorean.getSeatsNumber());
        assertFalse(deLorean.works());
    }

    @Test
    void testDeLorean44Creation(){
        //given
        DeLoreanFactory factory = new DeLorean44Factory();

        //when
        DeLorean deLorean = factory.createDeLorean();

        //then
        assertFalse(deLorean.isTimeMachine());
        assertEquals(2, deLorean.getSeatsNumber());
        assertFalse(deLorean.works());
    }

    @Test
    void testDeLorean80Creation(){
        //given
        DeLoreanFactory factory = new DeLorean80Factory();

        //when
        DeLorean deLorean = factory.createDeLorean();

        //then
        assertFalse(deLorean.isTimeMachine());
        assertEquals(50, deLorean.getSeatsNumber());
        assertFalse(deLorean.works());
    }

}
