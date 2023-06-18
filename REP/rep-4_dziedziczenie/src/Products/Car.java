package Products;

import Products.Vehicle;

public class Car extends Vehicle {
    String carBody;

    public String getCarBody() {
        return carBody;
    }

    public void setCarBody(String carBody) {
        this.carBody = carBody;
    }

    public Car(double price, String brand, String model, String carBody) {
        super(price, brand, model);
        this.carBody = carBody;
    }

    @Override
    public double calculateBargainPrice() {
        return super.calculateBargainPrice() - (super.calculateBargainPrice() * 0.15);
    }
}
