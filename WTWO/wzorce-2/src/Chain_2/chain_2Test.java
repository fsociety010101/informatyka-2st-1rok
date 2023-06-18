package Chain_2;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class chain_2Test {
    public static GrupaWiekowa handler;
    @BeforeAll
    static void prepare(){
        handler = new JStarszy(new Mlodziez(new Dorosli(null)));
    }
    @Test
     void test_1(){
        Tancerz tancerz = new Tancerz(3, 17, WynikZawodow.FINAL);
        handler.podwyzsz(tancerz);
        assertEquals(Klasa.S, clasa.getKlasy_tancerzy().get(tancerz.klasa) );


    }


}