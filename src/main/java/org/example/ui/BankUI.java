package org.example.ui;

import org.example.model.Account;
import org.example.model.SavingsAccount;
import org.example.model.Transaction;
import org.example.service.BankService;

import java.util.Scanner;

public class BankUI {
    private Scanner scanner;
    private BankService bankService;

    public BankUI() {
        this.scanner = new Scanner(System.in);
        this.bankService = new BankService();
    }

    public void start() {
        boolean running = true;
        while (running) {
            displayMainMenu();
            int choice = getIntInput("Välj ett alternativ: ");

            try {
                switch (choice) {
                    case 1:
                        createAccountMenu();
                        break;
                    case 2:
                        depositMoney();
                        break;
                    case 3:
                        withdrawMoney();
                        break;
                    case 4:
                        transferMoney();
                        break;
                    case 5:
                        showAccountInfo();
                        break;
                    case 6:
                        running = false;
                        System.out.println("Avslutar programmet...");
                        break;
                    default:
                        System.out.println("Ogiltigt val, försök igen.");
                }
            } catch (Exception e) {
                System.out.println("Ett fel uppstod: " + e.getMessage());
            }
            System.out.println("\nTryck Enter för att fortsätta...");
            scanner.nextLine();
        }
    }

    private void displayMainMenu() {
        System.out.println("\n=== Bankapplikation ===");
        System.out.println("1. Skapa nytt konto");
        System.out.println("2. Sätt in pengar");
        System.out.println("3. Ta ut pengar");
        System.out.println("4. Överför pengar");
        System.out.println("5. Visa kontoinformation");
        System.out.println("6. Avsluta");
    }

    private void createAccountMenu() {
        System.out.println("\n=== Skapa nytt konto ===");
        System.out.println("1. Sparkonto");
        System.out.println("2. Kreditkonto");

        int choice = getIntInput("Välj kontotyp: ");
        double initialBalance = getDoubleInput("Ange initialt saldo: ");

        String accountNumber;
        switch (choice) {
            case 1:
                double interestRate = getDoubleInput("Ange räntesats (i procent): ") / 100.0;
                accountNumber = bankService.createSavingsAccount(initialBalance, interestRate);
                break;
            case 2:
                double creditLimit = getDoubleInput("Ange kreditgräns: ");
                accountNumber = bankService.createCreditAccount(initialBalance, creditLimit);
                break;
            default:
                System.out.println("Ogiltigt val!");
                return;
        }
        System.out.println("Konto skapat! Kontonummer: " + accountNumber);
    }

    private void depositMoney() {
        System.out.println("\n=== Sätt in pengar ===");
        String accountNumber = getStringInput("Ange kontonummer: ");
        double amount = getDoubleInput("Ange belopp: ");

        try {
            Account account = bankService.getAccount(accountNumber);
            account.deposit(amount);
            System.out.println("Insättning genomförd. Nytt saldo: " + account.getBalance());
        } catch (Exception e) {
            System.out.println("Fel vid insättning: " + e.getMessage()) ;
        }
    }

    private void withdrawMoney() {
        System.out.println("\n=== Ta ut pengar ===");
        String accountNumber = getStringInput("Ange kontonummer: ");
        double amount = getDoubleInput("Ange belopp: ");

        try {
            Account account = bankService.getAccount(accountNumber);
            account.withdraw(amount);
            System.out.println("Uttag genomfört. Nytt saldo: " + account.getBalance());
        } catch (Exception e) {
            System.out.println("Fel vid uttag: " + e.getMessage());
        }
    }

    private void transferMoney() {
        System.out.println("\n=== Överför pengar ===");
        String fromAccount = getStringInput("Från kontonummer: ");
        String toAccount = getStringInput("Till kontonummer: ");
        double amount = getDoubleInput("Ange belopp: ");

        try {
            bankService.transfer(fromAccount, toAccount, amount);
            System.out.println("Överföring genomförd!");
            System.out.println("Nytt saldo för konto " + fromAccount + ": " +
                    bankService.getAccount(fromAccount).getBalance());
            System.out.println("Nytt saldo för konto " + toAccount + ": " +
                    bankService.getAccount(toAccount).getBalance());
        } catch (Exception e) {
            System.out.println("Fel vid överföring: " + e.getMessage());
        }
    }

    private void showAccountInfo() {
        System.out.println("\n=== Kontoinformation ===");
        String accountNumber = getStringInput("Ange kontonummer: ");

        try {
            Account account = bankService.getAccount(accountNumber);
            System.out.println("Kontonummer: " + account.getAccountNumber());
            System.out.println("Saldo: " + account.getBalance());

            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                System.out.println("Beräknad ränta: " + savingsAccount.calculateInterest());
            }

            System.out.println("\nTransaktionshistorik:");
            for (Transaction transaction : account.getTransactions()) {
                System.out.println(transaction);
            }
        } catch (Exception e) {
            System.out.println("Fel: " + e.getMessage());
        }
    }

    private int getIntInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Vänligen ange ett giltigt heltal." + e.getMessage());
            }
        }
    }

    private double getDoubleInput(String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return Double.parseDouble(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Vänligen ange ett giltigt belopp." + e.getMessage());
            }
        }
    }

    private String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}