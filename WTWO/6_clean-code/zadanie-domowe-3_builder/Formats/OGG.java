package Formats;

import Builder.StringBuilder;

import java.util.Arrays;
import java.util.Base64;

public class OGG implements StringBuilder {
    private String res;

    @Override
    public void budujNaglowek() {
        res += "Header: OggHeader\n";
    }

    @Override
    public void budujTagi() {
        res += "Tags: OggTags\n";
    }

    @Override
    public void budujBody(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i] > 100) array[i] = 100;
            else if (array[i] < -100) array[i] = -100;
        }

        String arrayToString = Arrays.toString(array);
        String encoded = Base64.getEncoder().encodeToString(arrayToString.getBytes());

        res += "Body: " + encoded + "\n";
    }

    @Override
    public void wyczysc() {
        res = "";
    }

    @Override
    public String getString() {
        return this.res;
    }
}
