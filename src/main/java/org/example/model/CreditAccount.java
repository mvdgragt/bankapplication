package org.example.model;

public class CreditAccount extends Account {
    private double creditLimit;

    public CreditAccount(String accountNumber, double initialBalance, double creditLimit) {
        super(accountNumber, initialBalance);
        this.creditLimit = creditLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (getBalance() + creditLimit) >= amount) {
        super.withdraw(amount);
        } else {
            System.out.println("The Amount exceeds the credit limit");
        }
    }

    public double getCreditLimit() {
        return creditLimit;
    }
}
