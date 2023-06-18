import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.APPEND;

public class WriteString implements WriteCommand {
    ReceiverStorage storage;

    public WriteString(ReceiverStorage storage) {
        this.storage = storage;
    }

    @Override
    public void execute() throws IOException {
        storage.writeString("file.txt", "savetofile");
    }

}
