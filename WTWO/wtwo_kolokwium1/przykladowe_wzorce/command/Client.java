package command;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Client {
    private ReceiverStorage storage;

    Client(){
        storage = new StorageInHotel();
    }

    public ReceiverStorage getStorage(){
        return storage;
    }
}
