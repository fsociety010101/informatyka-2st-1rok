package observer;

import java.nio.charset.Charset;
import java.util.Random;

public class WashingtonPost extends Producer {

    public void createArticle(){
        byte[] array = new byte[9];
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        Article article = new Article("George "+generatedString.toUpperCase(), "In the power of "+generatedString.toLowerCase(),
                "Long long "+generatedString+" ago.", "Washington Post");
        this.notify(article);
    }
}
