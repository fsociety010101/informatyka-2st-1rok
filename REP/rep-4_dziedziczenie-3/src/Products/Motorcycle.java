package Products;

public class Motorcycle extends Vehicle {
    String typeOfDrive;

    public String getTypeOfDrive() {
        return typeOfDrive;
    }

    public void setTypeOfDrive(String typeOfDrive) {
        this.typeOfDrive = typeOfDrive;
    }

    public Motorcycle(double price, String brand, String model, String typeOfDrive) {
        super(price, brand, model);
        this.typeOfDrive = typeOfDrive;
    }

    @Override
    public double calculateBargainPrice() {
        return super.calculateBargainPrice() - (super.calculateBargainPrice() * 0.1);
    }
}
