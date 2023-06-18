package Products;

public abstract class Vehicle extends Product {
    String brand;
    String model;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Vehicle(double price, String brand, String model) {
        super(price);
        this.brand = brand;
        this.model = model;
    }

    public double calculateBargainPrice() {
        return this.getPrice() - (this.getPrice() * 0.05);
    }
}
