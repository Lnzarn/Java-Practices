import java.util.Scanner;
public class CalculatorSimulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double dbFirstNum = 0, dbSecondNum = 0;
        System.out.println("----Calculator----\nChoose an action:");
        System.out.println("1. Addition\n2. Subtraction\n3. Multiplication\n4. Division");
        System.out.println("5. Modulo\n6. Factorial\n7. Power\nEnter your choice: ");
        int intChoice = scanner.nextInt();

        switch (intChoice) {
            case 1:
                askNumber(dbFirstNum, dbSecondNum, scanner);
                addition(dbFirstNum, dbSecondNum);
                break;
            case 2:
                subtraction(dbFirstNum, dbSecondNum);
                break;
            case 3:
                multiplication(dbFirstNum, dbSecondNum);
                break;
            case 4:
                division(dbFirstNum, dbSecondNum);
                break;
            case 5:
            case 6:
            case 7:
            default:
                break;
        }
        scanner.close();
    }
    public static void askNumber(double dbFirst, double dbSecond, Scanner scanner) {
        System.out.println("\nEnter First Number: ");
        dbFirst = scanner.nextInt();
        System.out.println("Enter Second Number: ");
        dbSecond = scanner.nextInt();
    }
    public static void addition(double dbFirst, double dbSecond) {
        System.out.println("\nAnswer: " + (dbFirst + dbSecond));
    }
    public static void subtraction(double dbFirst, double dbSecond) {
        System.out.println("\nAnswer: " + (dbFirst - dbSecond));
    }
    public static void multiplication(double dbFirst, double dbSecond) {
        System.out.println("\nAnswer: " + (dbFirst * dbSecond));
    }
    public static void division(double dbFirst, double dbSecond) {
        System.out.println("\nAnswer: " + (dbSecond == 0 ? "Undefined, Division by Zero": dbFirst/dbSecond));
    }
    public static void modulo(double dbFirst, double dbSecond) {
        System.out.println("\nAnswer: " + (dbSecond == 0 ? "Undefined, Division by Zero": dbFirst/dbSecond));
    }
    public static void factorial(double dbFirst, double dbSecond) {
        System.out.println("\nAnswer: " + (dbSecond == 0 ? "Undefined, Division by Zero": dbFirst/dbSecond));
    }
    public static void power(double dbFirst, double dbSecond) {
        System.out.println("\nAnswer: " + (dbSecond == 0 ? "Undefined, Division by Zero": dbFirst/dbSecond));
    }
}
