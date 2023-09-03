package com.CODSOFT;
import java.util.Scanner;

		class BankAccount {
		    private double balance;

		    public BankAccount(double initialBalance) {
		        balance = initialBalance;
		    }

		    public double getBalance() {
		        return balance;
		    }

		    public void deposit(double amount) {
		        if (amount > 0) {
		            balance += amount;
		        }
		    }

		    public boolean withdraw(double amount) {
		        if (amount > 0 && balance >= amount) {
		            balance -= amount;
		            return true;
		        }
		        return false;
		    }
		}

		public class ATMInterface {
		    private BankAccount account;

		    public ATMInterface(BankAccount account) {
		        this.account = account;
		    }

		    public void displayOptions() {
		        System.out.println("Welcome to Simple ATM");
		        System.out.println("1. Check Balance");
		        System.out.println("2. Deposit");
		        System.out.println("3. Withdraw");
		        System.out.println("4. Exit");
		    }

		    public void run() {
		        Scanner scanner = new Scanner(System.in);

		        while (true) {
		            displayOptions();
		            System.out.print("Select an option: ");
		            int choice = scanner.nextInt();

		            switch (choice) {
		                case 1:
		                    checkBalance();
		                    break;
		                case 2:
		                    System.out.print("Enter the deposit amount: ");
		                    double depositAmount = scanner.nextDouble();
		                    deposit(depositAmount);
		                    break;
		                case 3:
		                    System.out.print("Enter the withdrawal amount: ");
		                    double withdrawAmount = scanner.nextDouble();
		                    withdraw(withdrawAmount);
		                    break;
		                case 4:
		                    System.out.println("Thank you for using Simple ATM. Goodbye!");
		                    return;
		                default:
		                    System.out.println("Invalid option. Please select a valid option.");
		            }
		        }
		    }

		    public void checkBalance() {
		        System.out.println("Your account balance is: $" + account.getBalance());
		    }

		    public void deposit(double amount) {
		        if (amount > 0) {
		            account.deposit(amount);
		            System.out.println("$" + amount + " deposited successfully.");
		        } else {
		            System.out.println("Invalid deposit amount.");
		        }
		    }

		    public void withdraw(double amount) {
		        boolean success = account.withdraw(amount);
		        if (success) {
		            System.out.println("$" + amount + " withdrawn successfully.");
		        } else {
		            System.out.println("Withdrawal failed. Insufficient balance or invalid amount.");
		        }
		    }

		    public static void main(String[] args) {
		        BankAccount userAccount = new BankAccount(1000.0); // Initial balance is $1000
		        ATMInterface atm = new ATMInterface(userAccount);
		        atm.run();
		    }
		}
