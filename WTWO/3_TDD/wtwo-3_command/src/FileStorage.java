import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;

public class FileStorage implements ReceiverStorage {
    @Override
    public void writeString(String file, String line) throws IOException {
        Path f = Path.of(file);
        Files.writeString(f, line + "\n", APPEND);
    }

    @Override
    public void writeNumber(String file, int number) throws IOException {
        Path f = Path.of(file);
        Files.writeString(f, number + "\n", APPEND);
    }

    @Override
    public void writeSum(String file, int sum) throws IOException {
        Path fileName = Path.of(file);
        Files.writeString(fileName, "sum: " + sum + "\n", APPEND);
    }
}
