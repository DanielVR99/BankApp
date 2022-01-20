package com.java.objects;

public abstract class Account {
    private int accountNumber;
    private int clientNum;
    private String accountType;
    private final String BANK = "HCL Bank";

    public Account(int accountNumber, int clientNum, String accountType) {
        this.accountNumber = accountNumber;
        this.clientNum = clientNum;
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getBANK() {
        return BANK;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public int getClientNum() {
        return clientNum;
    }
}
