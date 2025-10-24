class Vehicle {
    private String brand;
    private int rentalprice = 100;

    int calculateRentalCost(int days){
        System.out.println("Pick a vehicle.");
        return 0;
    }

    String getBrand(){
        return brand;
    }
    int getRentalPrice(){
        return rentalprice;
    }

    void setBrand(String setbrand){
        this.brand = setbrand;
    }

    void setRentalPrice(int setprice){
        this.rentalprice = setprice;
    }
}

class Car extends Vehicle {
    @Override
    int calculateRentalCost(int days){
        return days * getRentalPrice();
    }
}

class Motor extends Vehicle {
    @Override
    int calculateRentalCost(int days){
        if (days > 5) {
            return ((days-5)*(int)(getRentalPrice()*0.8))+(5*getRentalPrice());
        }
        else {
            return days * getRentalPrice();
        }
    }
}

public class VehicleRental {
    public static void main(String[] args) {
        Vehicle[] vehicles = {new Car(), new Motor()};
        for (Vehicle v : vehicles){
            System.out.println(v.calculateRentalCost(7));
        }
    }
}
