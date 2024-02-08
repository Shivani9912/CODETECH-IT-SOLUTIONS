import java.util.Scanner;

public class ATM {

    private static final int BALANCE_INQUIRY = 1;
    private static final int WITHDRAWAL = 2;
    private static final int DEPOSIT = 3;
    private static final int EXIT = 4;

    private int balance;

    public ATM(int balance) {
        this.balance = balance;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("ATM Interface");
            System.out.println("1. Balance Inquiry");
            System.out.println("2. Withdrawal");
            System.out.println("3. Deposit");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case BALANCE_INQUIRY:
                    getBalance();
                    break;
                case WITHDRAWAL:
                    withdraw(scanner);
                    break;
                case DEPOSIT:
                    deposit(scanner);
                    break;
                case EXIT:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != EXIT);
    }

    private void getBalance() {
        System.out.println("Your balance is: $" + balance);
    }

    private void withdraw(Scanner scanner) {
        System.out.print("Enter the amount to withdraw: $");
        int amount = scanner.nextInt();

        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    private void deposit(Scanner scanner) {
        System.out.print("Enter the amount to deposit: $");
        int amount = scanner.nextInt();

        balance += amount;
        System.out.println("Deposit successful.");
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000);
        atm.start();
    }
}