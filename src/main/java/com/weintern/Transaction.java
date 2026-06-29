package com.weintern;

import java.time.LocalDateTime;

public class Transaction {

    private LocalDateTime dateTime;
    private String type;
    private double amount;

    public Transaction(String type, double amount) {
        this.dateTime = LocalDateTime.now();
        this.type = type;
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "dateTime=" + dateTime +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                '}';
    }
}