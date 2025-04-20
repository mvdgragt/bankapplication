package org.example.service;

import org.example.model.Account;
import org.example.model.CreditAccount;
import org.example.model.SavingsAccount;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class BankService {
    private Map<String, Account> accounts;

    public BankService() {
        this.accounts = new HashMap<>();
    }

    public String createCreditAccount(double initialBalance, double creditLimit) {
        String accountNumber = generateAccountNumber();
        accounts.put(accountNumber, new CreditAccount(accountNumber, initialBalance, creditLimit));
        return accountNumber;
    }

    public String createSavingsAccount(double initialBalance, double interestRate) {
        String accountNumber = generateAccountNumber();
        accounts.put(accountNumber, new SavingsAccount(accountNumber, initialBalance, interestRate));
        return accountNumber;
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);

        if (fromAccount == null || toAccount == null) {
            System.out.println("Account not found");
        }
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    private String generateAccountNumber() {
    return UUID.randomUUID().toString().substring(0,8);
    }

}
