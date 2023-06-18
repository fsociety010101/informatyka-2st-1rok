package command;

import java.util.ArrayList;
import java.util.List;

public class StorageInvoker {
    List<StorageCommand> commands = new ArrayList<StorageCommand>();

    StorageInvoker() {

    }

    public void addCommand(StorageCommand command){
        commands.add(command);
    }

    public void runAll(){
        for (StorageCommand command: commands){
            command.execute();
        }
    }
}
