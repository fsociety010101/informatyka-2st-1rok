package Formats;

import Builder.StringBuilder;

import java.util.Arrays;
import java.util.stream.Collectors;

public class WAV implements StringBuilder {
    private String res;

    @Override
    public void budujNaglowek() {
        res += "Header: WavHeader\n";
    }

    @Override
    public void budujTagi() {
        res += "Tags: \n";
    }

    @Override
    public void budujBody(int[] array) {
        String arrayToString = Arrays.toString(array).replaceAll("\\[|\\]", "");
        res += "Body: " + arrayToString + "\n";
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
