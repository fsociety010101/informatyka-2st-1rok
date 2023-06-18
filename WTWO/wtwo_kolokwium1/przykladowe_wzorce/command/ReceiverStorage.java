package command;

import java.util.HashMap;

public interface ReceiverStorage {

    HashMap<String, Integer> getStorage();

    void removeProduct(String product, Integer count);

    void addProduct(String product, Integer count);

}
