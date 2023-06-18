import Products.*;

public class Main {
    public static void displayPrices(ProductInterface[] arr) {
        for (ProductInterface it : arr) {
            Vehicle tempVehicle = (Vehicle) it;
            System.out.println("Name: " + tempVehicle.getBrand() + " " + tempVehicle.getModel());
            System.out.println("Price: " + tempVehicle.getPrice());
            System.out.println("Discounted price: " + tempVehicle.calculateBargainPrice());
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        ProductInterface[] arr = new Product[6];
        arr[0] = new Vehicle(1000, "brand1", "model1");
        arr[1] = new Vehicle(2000, "brand1", "model1");
        arr[2] = new Car(2500, "VW", "Passat", "Touring");
        arr[3] = new Car(99999, "Toyota", "Supra", "Coupe");
        arr[4] = new Motorcycle(4400, "Yamaha", "MT10", "Chain");
        arr[5] = new Motorcycle(6100, "Kawasaki", "Ninja", "Shaft");

        displayPrices(arr);
    }
}