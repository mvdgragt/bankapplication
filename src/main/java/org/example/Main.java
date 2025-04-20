package org.example;

import org.example.model.Account;

public class Main {
    public static void main(String[] args) {

        Account account = new Account("12345", 1000.0);
        System.out.println("Your initial balance: " + account.getBalance());
        try {
            account.deposit(500.0);
            System.out.println("After deposit you have: SEK" + account.getBalance());

            account.withdraw(200.0);
            System.out.println("After withdrawal you have: SEK" + account.getBalance());

            account.withdraw(2000.0);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}