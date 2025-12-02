import java.util.Scanner;

abstract class Employee {
    String name;

    abstract double calculateSalary();
    abstract void displayInfo();
    void companyPolicy() {
        System.out.println("Company Policy: All employees must submit attendance before payroll processing.");
    }
}

class FullTimeEmployee extends Employee {
    double dailyRate;
    int daysWorked;

    FullTimeEmployee(String name, double dailyRate, int daysWorked) {
        this.name = name;
        this.dailyRate = dailyRate;
        this.daysWorked = daysWorked;
    }

    @Override
    double calculateSalary() {
        return dailyRate * daysWorked;
    }

    @Override
    void displayInfo() {
        System.out.println("Employee Type: Full-Time");
        System.out.println("Name: " + name);
        System.out.println("Salary: P" + calculateSalary());
    }
}

class PartTimeEmployee extends Employee {
    double hourlyRate;
    int hoursWorked;

    PartTimeEmployee(String name, double hourlyRate, int hoursWorked) {
        this.name = name;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    double calculateSalary() {
        return hourlyRate * hoursWorked;
    }

    @Override
    void displayInfo() {
        System.out.println("Employee Type: Part-Time");
        System.out.println("Name: " + name);
        System.out.println("Salary: P" + calculateSalary());
    }
}

public class OOPAbstraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter employee type: ");
        String type = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        Employee emp; 

        if (type.equalsIgnoreCase("Full-Time")) {
            System.out.print("Enter daily rate: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter days worked: ");
            int days = scanner.nextInt();

            emp = new FullTimeEmployee(name, rate, days);

        } else { 
            System.out.print("Enter hourly rate: ");
            double rate = scanner.nextDouble();

            System.out.print("Enter hours worked: ");
            int hours = scanner.nextInt();

            emp = new PartTimeEmployee(name, rate, hours);
        }

        System.out.println();
        emp.displayInfo();
        emp.companyPolicy();

        scanner.close();
    }
}
