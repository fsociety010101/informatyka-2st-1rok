import java.io.IOException;

public interface ReceiverStorage {
    void writeString(String file, String line) throws IOException;

    void writeNumber(String file, int number) throws IOException;

    void writeSum(String file, int sum) throws IOException;
}
