package composite;

import composite.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class TestComposite {

    @Test
    void testAddingProduct(){
        //given
        PolskaAkademiaNauk pan = new PolskaAkademiaNauk();
        pan.addElement(new ZgromadzenieOgolne());
        WydzialNaukScislychINaukOZiemi wynoz = new WydzialNaukScislychINaukOZiemi();
        wynoz.addElement(new InstytutFizykiPAN());
        wynoz.addElement(new CentrumBadanKosmicznychPAN());
        pan.addElement(wynoz);

        //when
        String address = pan.getAddress();
        System.out.println(address);

        //then
        assertTrue(address.length() > 50);
    }


}
