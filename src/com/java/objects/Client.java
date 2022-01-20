package com.java.objects;

import java.util.ArrayList;

public class Client {
    private String clientName;
    private int clientNumber;
    private String email;
    private ArrayList<Account> accounts;
    private ArrayList<Transaction> transactions;

    public Client(String clientName, int clientNumber, String email) {
        this.clientName = clientName;
        this.clientNumber = clientNumber;
        this.email = email;
    }

    @Override
    public String toString() {
        return "com.java.objects.Client{" +
                "clientName='" + clientName + '\'' +
                ", clientNumber=" + clientNumber +
                ", clientEmail=" + email +
                '}';
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public int getClientNumber() {
        return clientNumber;
    }

    public void setClientNumber(int clientNumber) {
        this.clientNumber = clientNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(Transaction transaction) {
        this.transactions.add(transaction);
    }
}
