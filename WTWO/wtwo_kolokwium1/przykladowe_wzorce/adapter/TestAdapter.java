package adapter;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class TestAdapter {

    @Test
    @DisplayName("TEST ON")
    void testTurnOnLightsTest(){
        //given
        CityLightsWrapper wrapper = new CityLightsWrapper(new LegacyCityLights());

        //when
        wrapper.turnOnAllLigths();

        //then
        assertTrue(wrapper.getLightsAreTurnedON());
    }

    @Test
    @DisplayName("TEST OFF")
    void testTurnOffLightsTest(){
        //given
        CityLightsWrapper wrapper = new CityLightsWrapper(new LegacyCityLights());

        //when
        wrapper.turnOffAllLights();

        //then
        assertFalse(wrapper.getLightsAreTurnedON());
    }
}
