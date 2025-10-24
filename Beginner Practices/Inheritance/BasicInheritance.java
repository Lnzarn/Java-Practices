

class Vehicle {
    double speed;
    void go(){
        System.out.println("The vehicle has started to move.");
    }
    void stop(){
        System.out.println("The vehicle has stopped moving.");
    }
}

class Motor extends Vehicle {
    int wheels = 2;
}

public class BasicInheritance {
    public static void main(String[] args){
        Vehicle vehicle = new Vehicle();
        Motor motor = new Motor();
        vehicle.go();

        System.out.println("You are now in a motorcycle");
        motor.go();
        motor.stop();
        System.out.println(motor.wheels);
    }
}