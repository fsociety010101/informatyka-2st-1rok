import Builder.StringDirector;
import Formats.WAV;
import Formats.MP3;
import Formats.OGG;

public class Main {
    public static void main(String[] args) {
        int array[] = {3, 899, 54, 22, 61, 128, 9, 97, 616, 53};

        // WAV
        StringDirector stringDirector = new StringDirector(new WAV());
        String generatedString = stringDirector.wygenerujNapis(array);
        System.out.println(generatedString);

        // MP3
        stringDirector.setStringBuilder(new MP3());
        generatedString = stringDirector.wygenerujNapis(array);
        System.out.println(generatedString);

        // OGG
        stringDirector.setStringBuilder(new OGG());
        generatedString = stringDirector.wygenerujNapis(array);
        System.out.println(generatedString);

    }
}