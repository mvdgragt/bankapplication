package org.example;

import org.example.model.Account;
import org.example.model.SavingsAccount;
import org.example.model.Transaction;

public class Main {
    public static void main(String[] args) {

        SavingsAccount savingsAccount = new SavingsAccount("12345", 1000.0, 0.05);

        try {
            System.out.println("Initial Balance: " + savingsAccount.getBalance());
            savingsAccount.deposit(500.0);
            System.out.println("After deposit: " + savingsAccount.getBalance());
            double interest = savingsAccount.calculateInterest();
            System.out.println("Calculated interest: " + interest);
            savingsAccount.addInterest();
            System.out.println("After adding interest: " + savingsAccount.getBalance());

            System.out.println("\nTransaction history: ");
            for (Transaction transaction : savingsAccount.getTransactions()) {
                System.out.println(transaction);
            }
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}