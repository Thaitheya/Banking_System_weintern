package com.weintern.accounts;

import com.weintern.Transaction;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    protected double balance;
    protected List<Transaction> transactions;

    public BankAccount(String accountNumber,
                       String accountHolderName,
                       double balance) {

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }


    // Common methods
    public abstract void deposit(double amount);

    public abstract boolean withdraw(double amount);

    public abstract boolean transfer(BankAccount receiver, double amount);

    protected abstract void addTransaction(String type, double amount);

    public abstract void getStatement();

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }
}