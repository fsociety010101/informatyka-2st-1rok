package command;

public class DestroyProductItem implements StorageCommand {

    private String product;
    private Integer count;
    private ReceiverStorage storage;

    DestroyProductItem(ReceiverStorage storage, String product, Integer count){
        this.product = product;
        this.count = count;
        this.storage = storage;
    }

    public void execute() {
        storage.removeProduct(this.product, this.count);
    }
}
