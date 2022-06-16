import java.util.Scanner;

public class BankAccount {
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;

    BankAccount(String name, String id) {
        customerName = name;
        customerId = id;
    }

    void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
            previousTransaction = amount;
        }
    }

    void withdraw(int amount) {
        if (amount > 0) {
            balance -= amount;
            previousTransaction = -amount;
        }
    }

    void getPreviousTransaction() {
        if (previousTransaction > 0) {
            System.out.println("Deposited: " + previousTransaction);
        } else if (previousTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(previousTransaction));
        } else {
            System.out.println("No transaction reported!");
        }
    }

    void showMenu() {

        char option = '\0';

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome " + customerName);
        System.out.println("Your id is " + customerId);

        System.out.println("\nA: Check balance");
        System.out.println("B: Deposit");
        System.out.println("C: Withdraw");
        System.out.println("D: Previous transaction");
        System.out.println("E: Exit");

        do {
            System.out.println("---------------------------------------------\n");
            System.out.println("Enter an option: \n");

            option = scanner.next().charAt(0);
            System.out.println("\n");

            switch (option) {
                case 'A':
                    System.out.println("Your balance is " + balance);
                    System.out.println("---------------------------------------------\n");
                    break;
                case 'B':
                    System.out.println("Enter an amount to deposit");
                    int amount = scanner.nextInt();
                    deposit(amount);
                    System.out.println("---------------------------------------------\n");
                    break;
                case 'C':
                    System.out.println("Enter an amount to withdraw");
                    int amount2 = scanner.nextInt();
                    withdraw(amount2);
                    System.out.println("---------------------------------------------\n");
                    break;
                case 'D':
                    getPreviousTransaction();
                    System.out.println("---------------------------------------------\n");
                    break;
                case 'E':
                    System.out.println("Thank you for using Bank Account application!");
                    break;
                default:
                    System.out.println("Invalid option! Please enter again.");
            }

        } while (option != 'E');
    }
}
