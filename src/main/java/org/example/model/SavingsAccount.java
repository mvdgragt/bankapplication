package org.example.model;

public class SavingsAccount extends Account{

    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance, double interestRate) {
        super(accountNumber, initialBalance);
        this.interestRate = interestRate;
    }
    public double calculateInterest() {
        return getBalance() * interestRate;
    }
    public void addInterest() {
        double interest = calculateInterest();
        deposit(interest);
    }
}
