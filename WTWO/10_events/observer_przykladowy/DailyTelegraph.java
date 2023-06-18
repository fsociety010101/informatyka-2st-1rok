package observer;

import java.nio.charset.Charset;
import java.util.Random;

public class DailyTelegraph extends Producer {

    public void createArticle(){
        byte[] array = new byte[7];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        Article article = new Article("Auth "+generatedString.toUpperCase(), "The "+generatedString.toLowerCase(),
        "It was very "+generatedString+" night.", "Daily Telegraph");
        this.notify(article);
    }
}
