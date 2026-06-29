package com.weintern;

import com.weintern.accounts.BankAccount;
import com.weintern.accounts.CurrentAccount;
import com.weintern.accounts.SavingsAccount;

import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, BankAccount> accounts;
    private static int accountCounter = 1001;

    public Bank() {
        accounts = new HashMap<>();
    }

    private String generateAccountNumber() {
        return "ACC" + accountCounter++;
    }

    // Create Savings Account
    public String createSavingsAccount(String holderName, double initialBalance) {
        String accountNumber = generateAccountNumber();

        BankAccount account = new SavingsAccount(
                accountNumber,
                holderName,
                initialBalance
        );

        accounts.put(accountNumber, account);

        return accountNumber;
    }

    // Create Current Account
    public String createCurrentAccount(String holderName, double initialBalance) {
        String accountNumber = generateAccountNumber();

        BankAccount account = new CurrentAccount(
                accountNumber,
                holderName,
                initialBalance
        );

        accounts.put(accountNumber, account);

        return accountNumber;
    }

    // Find Account
    public BankAccount getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // Deposit
    public void deposit(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.deposit(amount);
    }

    // Withdraw
    public void withdraw(String accountNumber, double amount) {
        BankAccount account = getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.withdraw(amount);
    }

    // Transfer
    public void transfer(String fromAccount, String toAccount, double amount) {

        BankAccount sender = getAccount(fromAccount);
        BankAccount receiver = getAccount(toAccount);

        if (sender == null || receiver == null) {
            System.out.println("Invalid account number.");
            return;
        }

        if (sender.transfer(receiver, amount)) {
            System.out.println("Transfer Successful.");
        } else {
            System.out.println("Transfer Failed.");
        }
    }

    // Check Balance
    public void checkBalance(String accountNumber) {

        BankAccount account = getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        System.out.println("Current Balance : ₹" + account.getBalance());
    }

    // Print Statement
    public void printStatement(String accountNumber) {

        BankAccount account = getAccount(accountNumber);

        if (account == null) {
            System.out.println("Account not found.");
            return;
        }

        account.getStatement();
    }

    // Display All Accounts
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }

        for (BankAccount account : accounts.values()) {
            System.out.println("-------------------------------");
            System.out.println("Account Number : " + account.getAccountNumber());
            System.out.println("Account Holder : " + account.getAccountHolderName());
            System.out.println("Balance        : ₹" + account.getBalance());
        }
    }
}