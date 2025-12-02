import java.util.Scanner;

class Shape {
    double calculateArea() {
        System.out.println("This is gonna be overriden.");
        return 0;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width, height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }
}

class Triangle extends Shape {
    double base, height;

    Triangle(double base, double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

public class OOPPolymorphism {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter how many shapes: ");
        int amountOfShapes = scanner.nextInt();
        Shape[] shapes = new Shape[amountOfShapes];

        for (int i = 0; i < amountOfShapes; i++){
            System.out.println("\nNo." + (i+1) + " Shape:");
            System.out.print("Enter shape type: ");
            scanner.nextLine();
            String shapeType = scanner.nextLine();
            if(shapeType.equalsIgnoreCase("Circle")){
                System.out.print("Enter radius: ");
                double radius = scanner.nextDouble();
                shapes[i] = new Circle(radius);
            } else if (shapeType.equalsIgnoreCase("Rectangle")){
                System.out.print("Enter width: ");
                double width = scanner.nextDouble();
                System.out.print("Enter height: ");
                double height = scanner.nextDouble();
                shapes[i] = new Rectangle(width, height);
            } else if (shapeType.equalsIgnoreCase("Triangle")){
                 System.out.print("Enter base: ");
                double base = scanner.nextDouble();
                System.out.print("Enter height: ");
                double triHeight = scanner.nextDouble();
                shapes[i] = new Triangle(base, triHeight);
            }
        }     

        System.out.println("\n--- AREAS ---");
        for (Shape s : shapes) {
            System.out.printf("Area: %.2f\n", s.calculateArea());
        }

        scanner.close();
    }
}
