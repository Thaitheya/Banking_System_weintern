package com.weintern;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while (true) {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Transfer");
            System.out.println("6. Check Balance");
            System.out.println("7. Print Statement");
            System.out.println("8. Display All Accounts");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Account Holder Name: ");
                    String sName = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double sBalance = sc.nextDouble();

                    String sAccNo = bank.createSavingsAccount(sName, sBalance);

                    System.out.println("Savings Account Created Successfully.");
                    System.out.println("Account Number: " + sAccNo);
                    break;

                case 2:
                    System.out.print("Enter Account Holder Name: ");
                    String cName = sc.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double cBalance = sc.nextDouble();

                    String cAccNo = bank.createCurrentAccount(cName, cBalance);

                    System.out.println("Current Account Created Successfully.");
                    System.out.println("Account Number: " + cAccNo);
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    String depositAcc = sc.next();

                    System.out.print("Enter Amount: ");
                    double depositAmt = sc.nextDouble();

                    bank.deposit(depositAcc, depositAmt);
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    String withdrawAcc = sc.next();

                    System.out.print("Enter Amount: ");
                    double withdrawAmt = sc.nextDouble();

                    bank.withdraw(withdrawAcc, withdrawAmt);
                    break;

                case 5:
                    System.out.print("From Account Number: ");
                    String from = sc.next();

                    System.out.print("To Account Number: ");
                    String to = sc.next();

                    System.out.print("Enter Amount: ");
                    double transferAmt = sc.nextDouble();

                    bank.transfer(from, to, transferAmt);
                    break;

                case 6:
                    System.out.print("Enter Account Number: ");
                    String balanceAcc = sc.next();

                    bank.checkBalance(balanceAcc);
                    break;

                case 7:
                    System.out.print("Enter Account Number: ");
                    String statementAcc = sc.next();

                    bank.printStatement(statementAcc);
                    break;

                case 8:
                    bank.displayAllAccounts();
                    break;

                case 9:
                    System.out.println("Thank you for using Banking System!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}