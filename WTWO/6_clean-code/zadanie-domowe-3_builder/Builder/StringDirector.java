package Builder;

public class StringDirector {
    private StringBuilder stringBuilder;

    public StringDirector(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public void setStringBuilder(StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;
    }

    public String wygenerujNapis(int[] array) {
        // todo: wyczysc string
        stringBuilder.wyczysc();
        stringBuilder.budujNaglowek();
        stringBuilder.budujTagi();
        stringBuilder.budujBody(array);

        return stringBuilder.getString();
    }
}
