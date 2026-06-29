package com.weintern.accounts;

import com.weintern.Transaction;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(String accountNumber,
                          String accountHolderName,
                          double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }

        balance += amount;
        addTransaction("DEPOSIT", amount);
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (amount > balance) {
            System.out.println("Insufficient balance.");
            return false;
        }

        balance -= amount;
        addTransaction("WITHDRAW", amount);
        return true;
    }

    @Override
    public boolean transfer(BankAccount receiver, double amount) {

        if (withdraw(amount)) {
            receiver.deposit(amount);
            addTransaction("TRANSFER", amount);
            return true;
        }

        return false;
    }

    @Override
    protected void addTransaction(String type, double amount) {
        // Depends on your Transaction constructor
    }

    @Override
    public void getStatement() {
        System.out.println("Account Number: " + getAccountNumber());
        System.out.println("Account Holder: " + getAccountHolderName());
        System.out.println("Balance: " + getBalance());

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}