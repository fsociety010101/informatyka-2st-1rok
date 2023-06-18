import Products.Car;
import Products.Motorcycle;
import Products.Product;
import Products.Vehicle;

public class Main {
    public static void displayPrices(Product[] arr) {
        for (Product it : arr) {
            Vehicle tempVehicle = (Vehicle) it;
            System.out.println("Name: " + tempVehicle.getBrand() + " " + tempVehicle.getModel());
            System.out.println("Price: " + tempVehicle.getPrice());
            System.out.println("Discounted price: " + tempVehicle.calculateBargainPrice());
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Product[] arr = new Product[4];
//        arr[0] = new Vehicle(1000, "brand1", "model1");
//        arr[1] = new Vehicle(2000, "brand1", "model1");
        arr[0] = new Car(2500, "VW", "Passat", "Touring");
        arr[1] = new Car(99999, "Toyota", "Supra", "Coupe");
        arr[2] = new Motorcycle(4400, "Yamaha", "MT10", "Chain");
        arr[3] = new Motorcycle(6100, "Kawasaki", "Ninja", "Shaft");

        displayPrices(arr);
    }
}