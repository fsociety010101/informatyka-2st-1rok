package command;

public class AddProductItem implements StorageCommand {

    private String product;
    private Integer count;
    private ReceiverStorage storage;

    AddProductItem(ReceiverStorage storage, String product, Integer count){
        this.product = product;
        this.count = count;
        this.storage = storage;
    }

    public void execute() {
        storage.addProduct(this.product, this.count);
    }

}
