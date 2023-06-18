package Chain;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChainTest {
    public static Handler handler;
    @BeforeAll
    static void prepare(){
        handler = new ImportantCheck(new SpamChecker(new OtherChecker(null)));


    }

    @Test
    void test_1(){

        Napis napis = new Napis("Ernest");
        handler.handle(napis);

        System.out.println(napis.getNapis());


    }
}