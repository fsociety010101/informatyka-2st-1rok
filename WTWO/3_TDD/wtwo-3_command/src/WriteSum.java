import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.APPEND;

public class WriteSum implements WriteCommand {

    int sum = 0;
    ReceiverStorage storage;

    public WriteSum(ReceiverStorage storage) {
        this.storage = storage;
    }

    private void calculateSum(String file) {
        int num = 0;
        try {
            File f = new File(file);
            Scanner scanner = new Scanner(f);
            while (scanner.hasNext()) {
                try {
                    num = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException ignored) {
                }
                sum += num;
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    @Override
    public void execute() throws IOException {
        calculateSum("file.txt");
        storage.writeSum("file.txt",this.sum);
    }

}
