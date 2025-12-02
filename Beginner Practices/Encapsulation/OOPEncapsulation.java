import java.util.Scanner;

class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;

    void setAccountNumber(String number){
        this.accountNumber = number;
    }

    void setAccountHolder(String name){
        this.accountHolder = name;
    }

    void setBalance(double amount){
        if (amount < 0) System.out.println("Error: Balance cannot be negative.");
        else this.balance = amount;
    }

    void deposit(double amount) {
        if (amount <= 0) System.out.println("Error: Invalid deposit amount.");
        else{
            System.out.println("Successfully deposited P" + amount); 
            this.balance += amount;
        }
    }

    void withdraw(double amount){
        double temp = this.balance;
        if ((temp - amount) < 0) System.out.println("Error: Insufficient funds.");
        else{
            System.out.println("Successfully withdrawn P" + amount); 
            this.balance -= amount;
        }
    }

    void displayAccountInfo(){
        System.out.println("\n--- Account Information ---");
        System.out.println("Account Holder: " + this.accountHolder);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Current Balance: P" + this.balance);
        System.out.println(); //Adding a space
    }
}

public class OOPEncapsulation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount bankAcc = new BankAccount();
        System.out.print("Enter account name: ");
        String tempName = scanner.nextLine();
        System.out.print("Enter account number: ");
        String tempNumber = scanner.nextLine();
        System.out.print("Enter initial balance: ");
        double tempAmount = scanner.nextDouble();

        bankAcc.setAccountHolder(tempName);
        bankAcc.setAccountNumber(tempNumber);
        bankAcc.setBalance(tempAmount);

        bankAcc.displayAccountInfo();

        System.out.print("Enter amount to deposit: ");
        tempAmount = scanner.nextDouble();
        bankAcc.deposit(tempAmount);
        System.out.print("Enter amount to withdraw: ");
        tempAmount = scanner.nextDouble();
        bankAcc.withdraw(tempAmount);

        bankAcc.displayAccountInfo();
        scanner.close();
    }
}
