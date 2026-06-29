package com.weintern.accounts;

import com.weintern.Transaction;

public class SavingsAccount extends BankAccount {

    private static final double MIN_BALANCE = 1000.0;

    public SavingsAccount(String accountNumber,
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

        System.out.println("Deposit Successful.");
    }

    @Override
    public boolean withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }

        if (balance - amount < MIN_BALANCE) {
            System.out.println("Minimum balance of ₹1000 must be maintained.");
            return false;
        }

        balance -= amount;
        addTransaction("WITHDRAW", amount);

        System.out.println("Withdrawal Successful.");
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
        // Implement according to your Transaction class
        // Example:
        // transactions.add(new Transaction(type, amount));
    }

    @Override
    public void getStatement() {

        System.out.println("Account Number : " + getAccountNumber());
        System.out.println("Account Holder : " + getAccountHolderName());
        System.out.println("Balance : ₹" + getBalance());

        System.out.println("Transaction History");

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}