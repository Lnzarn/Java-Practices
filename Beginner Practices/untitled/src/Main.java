import java.util.Scanner;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What's your name? > ");
        String name = scanner.nextLine();

        System.out.println("Hello " + name + ", Welcome to Java!");

        scanner.close();



    }
}