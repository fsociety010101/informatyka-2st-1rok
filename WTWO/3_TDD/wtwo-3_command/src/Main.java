import java.io.IOException;
import java.io.PrintWriter;


public class Main {
    public static void main(String[] args) throws IOException {
        new PrintWriter("file.txt").close();

        FileStorage abc = new FileStorage();

        WriteString a = new WriteString(abc);
        a.execute();

        WriteNumber b = new WriteNumber(abc);
        b.execute();
        b.execute();

        WriteSum c = new WriteSum(abc);
        c.execute();

    }
}