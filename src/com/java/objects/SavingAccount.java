package com.java.objects;

import com.java.objects.Account;

public class SavingAccount extends Account {
    private float money;
    private float interestRate;

    public SavingAccount(int accountNumber, int clientNum, float interestRate, float money) {
        super(accountNumber, clientNum, "Saving");
        this.interestRate = interestRate;
        this.money = money;
    }

    @Override
    public String toString() {
        return "com.java.objects.SavingAccount{" +
                "money=" + money +
                ", interestRate=" + interestRate +
                ", accountNumber=" + super.getAccountNumber() +
                ", accountType=" + super.getAccountType() +
                '}';
    }

    public float getMoney() {
        return money;
    }

    public void addMoney(float money) {
        this.money = this.money + money;
    }

    public float getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(float interestRate) {
        this.interestRate = interestRate;
    }
}
