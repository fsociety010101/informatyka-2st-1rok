package command;

import java.util.HashMap;

public class ChangeProductName implements StorageCommand {

    private String oldProductName;
    private String newProductName;
    private ReceiverStorage storage;

    ChangeProductName(ReceiverStorage storage, String oldProductName, String newProductName){
        this.oldProductName = oldProductName;
        this.newProductName = newProductName;
        this.storage = storage;
    }

    public void execute() {
        HashMap<String, Integer> storageSnapshot = storage.getStorage();
        Integer count = storageSnapshot.get(oldProductName);
        storage.addProduct(newProductName, count);
        storage.removeProduct(oldProductName, count);
    }
}
