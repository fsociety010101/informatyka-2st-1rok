package Formats;

import Builder.StringBuilder;

import java.util.Arrays;
import java.util.Base64;

public class MP3 implements StringBuilder {
    private String res;

    @Override
    public void budujNaglowek() {
        res += "Header: Mp3Header\n";
    }

    @Override
    public void budujTagi() {
        res += "Tags: Mp3Tags\n";
    }

    @Override
    public void budujBody(int[] array) {
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
