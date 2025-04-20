package org.example;

import org.example.model.Account;
import org.example.model.Transaction;

public class Main {
    public static void main(String[] args) {

        Account account = new Account("12345", 1000.0);

        try {
            account.deposit(500.0);
            account.withdraw(200.0);

            System.out.println("\nTransaction History:");
            for(Transaction transaction : account.getTransactions())
                System.out.println(transaction);

            System.out.println("Withdrawal " + account.getBalance());

            account.withdraw(2000.0);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}