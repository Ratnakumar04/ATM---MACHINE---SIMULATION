package Automated_Teller_Machine;
import java.util.ArrayList;
import java.util.Scanner;


public class Task_1__ATM_project {
	    
	    // Fields for account balance, PIN, and transaction history
	    private double balance;
	    private int pin;
	    private ArrayList<String> transactionHistory;

	    // Constructor to initialize balance, PIN, and transaction history
	    public Task_1__ATM_project(double initialBalance, int initialPin) {
	        this.balance = initialBalance;
	        this.pin = initialPin;
	        this.transactionHistory = new ArrayList<>();
	        this.transactionHistory.add("Initial Balance: $" + initialBalance);
	    }

	    // Function to display the main menu
	    public void showMenu() {
	        System.out.println("\nATM Menu:");
	        System.out.println("1. Account Balance Inquiry");
	        System.out.println("2. Cash Withdrawal");
	        System.out.println("3. Cash Deposit");
	        System.out.println("4. Change PIN");
	        System.out.println("5. Transaction History");
	        System.out.println("6. Exit");
	        System.out.print("Please select an option: ");
	    }

	    // Method to inquire account balance
	    public void accountBalance() {
	        System.out.println("Current Balance: $" + this.balance);
	        this.transactionHistory.add("Balance Inquiry: $" + this.balance);
	    }

	    // Method to withdraw cash
	    public void withdrawCash(double amount) {
	        if (amount <= balance) {
	            balance -= amount;
	            System.out.println("Withdrawal Successful: $" + amount);
	            this.transactionHistory.add("Withdrawn: $" + amount);
	        } else {
	            System.out.println("Insufficient Balance!");
	        }
	    }

	    // Method to deposit cash
	    public void depositCash(double amount) {
	        balance += amount;
	        System.out.println("Deposit Successful: $" + amount);
	        this.transactionHistory.add("Deposited: $" + amount);
	    }

	    // Method to change the PIN
	    public void changePin(int newPin) {
	        this.pin = newPin;
	        System.out.println("PIN Successfully Changed.");
	        this.transactionHistory.add("PIN Changed.");
	    }

	    // Method to show transaction history
	    public void showTransactionHistory() {
	        System.out.println("Transaction History:");
	        for (String transaction : transactionHistory) {
	            System.out.println(transaction);
	        }
	    }

	    // Method to validate the PIN
	    public boolean validatePin(int enteredPin) {
	        return this.pin == enteredPin;
	    }

	    public static void main(String[] args) {
	        // Initialize the ATM with an initial balance and PIN
	    	Task_1__ATM_project atm = new Task_1__ATM_project(1000.00, 1234);

	        Scanner scanner = new Scanner(System.in);
	        int attempts = 3;

	        // Prompt user to enter PIN and validate
	        while (attempts > 0) {
	            System.out.print("Enter PIN: ");
	            int enteredPin = scanner.nextInt();
	            if (atm.validatePin(enteredPin)) {
	                System.out.println("PIN Verified.\n");

	                boolean exit = false;
	                while (!exit) {
	                    atm.showMenu();
	                    int option = scanner.nextInt();
	                    switch (option) {
	                        case 1: // Account Balance Inquiry
	                            atm.accountBalance();
	                            break;
	                        case 2: // Cash Withdrawal
	                            System.out.print("Enter withdrawal amount: $");
	                            double withdrawalAmount = scanner.nextDouble();
	                            atm.withdrawCash(withdrawalAmount);
	                            break;
	                        case 3: // Cash Deposit
	                            System.out.print("Enter deposit amount: $");
	                            double depositAmount = scanner.nextDouble();
	                            atm.depositCash(depositAmount);
	                            break;
	                        case 4: // Change PIN
	                            System.out.print("Enter new PIN: ");
	                            int newPin = scanner.nextInt();
	                            atm.changePin(newPin);
	                            break;
	                        case 5: // Transaction History
	                            atm.showTransactionHistory();
	                            break;
	                        case 6: // Exit
	                            exit = true;
	                            System.out.println("Thank you for using the ATM. Goodbye!");
	                            break;
	                        default:
	                            System.out.println("Invalid option. Please try again.");
	                    }
	                }
	                break;
	            } else {
	                attempts--;
	                if (attempts > 0) {
	                    System.out.println("Incorrect PIN. You have " + attempts + " attempts left.");
	                } else {
	                    System.out.println("Account locked due to too many failed attempts.");
	                }
	            }
	        }
	        scanner.close();
	    }
	}


