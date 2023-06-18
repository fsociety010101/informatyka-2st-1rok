package command;

import java.util.HashMap;

public class StorageInHotel implements ReceiverStorage {
    HashMap<String, Integer> storage;

    StorageInHotel(){
        storage = new HashMap<String, Integer>();
        storage.put("plates",100);
        storage.put("spoons",1000);
        storage.put("forks", 500);
    }

    public HashMap<String, Integer> getStorage(){
        return new HashMap<String, Integer>(storage);
    }

    public void removeProduct(String product, Integer count){
        if (storage.containsKey(product) && storage.get(product) > count){
            storage.put(product, storage.get(product) - count);
        } else {
            storage.put(product, 0);
        }
    }

    public void addProduct(String product, Integer count){
        if (storage.containsKey(product)){
            storage.put(product, storage.get(product) + count);
        } else {
            storage.put(product, count);
        }
    }
}
