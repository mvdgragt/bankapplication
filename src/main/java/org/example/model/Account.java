package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        addTransaction(new Transaction("Initial deposit", initialBalance));

    }

    public void deposit(double amount){
        if (amount>0) {
            balance += amount;
            addTransaction(new Transaction("Deposit", amount));
        } else {
            System.out.println("Amount must be a positive amount");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            addTransaction(new Transaction("Withdrawal", amount));
        } else {
            System.out.println("You don't have enough money on your account");
        }
    }
    private void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction>getTransactions(){
        return new ArrayList<>(transactions);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }


}
