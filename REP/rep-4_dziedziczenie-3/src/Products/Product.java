package Products;

public class Product implements ProductInterface {
    double price;

    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    public Product(double price) {
        this.price = price;
    }

    public double calculateBargainPrice() {
        return price;
    }
}


