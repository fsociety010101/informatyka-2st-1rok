import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;

public class WriteNumber implements WriteCommand {
    ReceiverStorage storage;

    public WriteNumber(ReceiverStorage storage) {
        this.storage = storage;
    }

    @Override
    public void execute() throws IOException {
        storage.writeNumber("file.txt", 10000);
    }
}
