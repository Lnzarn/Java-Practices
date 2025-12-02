import java.util.Scanner;

class Vehicle {
    String brand;
    String model;
    int year;

   void displayDetails(){
        System.out.println("--- Vehicle Details ---");
        System.out.println("Brand: " + brand + " | Model: " + model + " | Year: " + year);
    }
}

class Car extends Vehicle {
    String numberOfDoors;

    Car(String brand, String model, int year, String doors) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.numberOfDoors = doors;
    }
    @Override
    void displayDetails(){
        System.out.println("\n--- Vehicle Details ---");
        System.out.println("Brand: " + brand + " | Model: " + model + " | Year: " + year + " | Doors: " + numberOfDoors);
    }
}

class Motorcycle extends Vehicle {
    String engineType;
    Motorcycle(String brand, String model, int year, String engine) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.engineType = engine;
    }
    @Override 
    void displayDetails(){
        System.out.println("\n--- Vehicle Details ---");
        System.out.println("Brand: " + brand + " | Model: " + model + " | Year: " + year + " | Engine: " + engineType);
    }
}

public class OOPInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tryAgain;
        do {
            System.out.print("Enter vehicle type: ");
            String vehicle = scanner.nextLine();
            if (!vehicle.equalsIgnoreCase("Car") && !vehicle.equalsIgnoreCase("Motorcycle")){
                System.out.println("Pick between a car or motorcycle.");
                break;
            };
            System.out.print("Enter Brand: ");
            String tempBrand = scanner.nextLine();
            System.out.print("Enter model: ");
            String tempModel = scanner.nextLine();
            System.out.print("Enter year: ");
            int tempYear = scanner.nextInt();
            System.out.print((vehicle.equalsIgnoreCase("Car")) ? "Enter number of doors: " : "Enter engine type: ");
            scanner.nextLine();
            String tempOtherDetail = scanner.nextLine();

            if(vehicle.equalsIgnoreCase("Car")){
                Car car = new Car(tempBrand, tempModel, tempYear, tempOtherDetail);
                car.displayDetails();
            } else{
                Motorcycle motor = new Motorcycle(tempBrand, tempModel, tempYear, tempOtherDetail);
                motor.displayDetails();
            } 

            System.out.println("\nContinue with another vehicle?");
            tryAgain = scanner.nextLine();
        } while (!tryAgain.equalsIgnoreCase("No"));
        scanner.close();
    }

}

