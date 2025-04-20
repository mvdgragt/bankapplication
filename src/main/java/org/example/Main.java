package org.example;

import org.example.model.Account;
import org.example.model.CreditAccount;
import org.example.model.SavingsAccount;
import org.example.model.Transaction;
import org.example.service.Bankservice;

public class Main {
    public static void main(String[] args) {
        Bankservice bank = new Bankservice();

        //Create Accounts
        String creditAccountNumber = bank.createCreditAccount(1000.0,500.0);
        String savingsAccountNumber = bank.createSavingsAccount(1000.0,0.05);

        System.out.println("Created accounts:");
        System.out.println("Saving accounts:" + savingsAccountNumber);
        System.out.println("Credit Account: " + creditAccountNumber);

        try {

            bank.transfer(savingsAccountNumber, creditAccountNumber, 500.0);

            System.out.println("\nAfter transfer:");
            System.out.println("Savings Account balance: " + bank.getAccount(savingsAccountNumber).getBalance());
            System.out.println("Credit Account balance: " + bank.getAccount(creditAccountNumber).getBalance());

//            System.out.println("Testing credit account:");
//            System.out.println("Initial Balance: " + creditAccount.getBalance());
//            creditAccount.withdraw(1200.0);
//            System.out.println("After withdrawal: "+ creditAccount.getBalance());
//            creditAccount.withdraw(1000.0);
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
//        System.out.println("\nTransaction history: ");
//        for (Transaction transaction : savingsAccount.getTransactions()) {
//            System.out.println(transaction);
//        }
    }
}