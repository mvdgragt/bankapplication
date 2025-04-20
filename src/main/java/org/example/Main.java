package org.example;

import org.example.model.Account;
import org.example.model.CreditAccount;
import org.example.model.SavingsAccount;
import org.example.model.Transaction;

public class Main {
    public static void main(String[] args) {

        //Test SavingsAccount
        SavingsAccount savingsAccount = new SavingsAccount("S12345", 1000.0, 0.05);

        //Test CreditAccount
        CreditAccount creditAccount = new CreditAccount("C12345", 1000.0, 500.0);

        try {
            System.out.println("Testing credit account:");
            System.out.println("Initial Balance: " + creditAccount.getBalance());
            creditAccount.withdraw(1200.0);
            System.out.println("After withdrawal: "+ creditAccount.getBalance());
            creditAccount.withdraw(1000.0);
//
//            savingsAccount.deposit(500.0);
//            System.out.println("After deposit: " + savingsAccount.getBalance());
//            double interest = savingsAccount.calculateInterest();
//            System.out.println("Calculated interest: " + interest);
//            savingsAccount.addInterest();
//            System.out.println("After adding interest: " + savingsAccount.getBalance());


        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("\nTransaction history: ");
        for (Transaction transaction : savingsAccount.getTransactions()) {
            System.out.println(transaction);
        }
    }
}