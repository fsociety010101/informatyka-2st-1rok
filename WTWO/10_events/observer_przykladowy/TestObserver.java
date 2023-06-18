package observer;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestObserver {
    private DailyTelegraph dt;
    private WashingtonPost wp;
    private PublicationLeader pl;
    private ArticleCounter ac;

    @BeforeEach
    void preparations(){
        dt = new DailyTelegraph();
        wp = new WashingtonPost();
        pl = new PublicationLeader();
        ac = new ArticleCounter();
        dt.subscribe(ac);
        dt.subscribe(pl);
        wp.subscribe(ac);
        wp.subscribe(pl);
    }


    @Test
    void testOne(){
        //given

        //when
        dt.createArticle();

        //then
        assertEquals("Daily Telegraph", pl.whoIsTheLeader());
        assertEquals(1, ac.getCounter());
    }

    @Test
    void testCounter(){
        //given
        dt.createArticle();
        wp.createArticle();

        //when
        wp.createArticle();

        //then
        assertEquals(3, ac.getCounter());
    }


    @Test
    void testLeader(){
        //given
        dt.createArticle();
        dt.createArticle();
        wp.createArticle();
        wp.createArticle();

        //when
        wp.createArticle();

        //then
        assertEquals("Washington Post", pl.whoIsTheLeader());
    }
}
