package command;

import java.util.HashMap;

public class PrintProductStats implements StorageCommand {

    private String product;
    private ReceiverStorage storage;

    PrintProductStats(ReceiverStorage storage, String product){
        this.product = product;
        this.storage = storage;
    }

    public void execute() {
        HashMap<String, Integer> storageSnapshot = storage.getStorage();
        System.out.println(storageSnapshot.get(product));
    }
}
