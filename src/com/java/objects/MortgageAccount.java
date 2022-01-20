package com.java.objects;

import com.java.objects.Account;

public class MortgageAccount extends Account {
    private float debt;
    private float monthPay;
    private float interest;

    public MortgageAccount(int accountNumber, int clientNum, float debt, float monthPay, float interest) {
        super(accountNumber, clientNum, "Mortgage");
        this.debt = debt;
        this.monthPay = monthPay;
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "com.java.objects.MortgageAccount{" +
                "debt=" + debt +
                ", monthPay=" + monthPay +
                ", interest=" + interest +
                ", accountNumber=" + super.getAccountNumber() +
                ", accountType=" + super.getAccountType() +
                '}';
    }

    public float getDebt() {
        return debt;
    }

    public void payDebt() {
        this.debt = this.debt-this.monthPay;
    }
}
