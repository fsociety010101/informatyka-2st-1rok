package Products;

public abstract class Product {
    double price;

    public double getPrice() {
        return price;
    }

    public Product(double price) {
        this.price = price;
    }

    public abstract double calculateBargainPrice();
}


