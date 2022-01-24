package com.java.objects;

import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
    private int transactionNum;
    private int accNum1;
    private int accNum2;
    private float qty;
    private LocalDateTime date;
    private String transactionType;

    public Transaction(int transactionNum, int accNum1, int accNum2, float qty, LocalDateTime date, String transactionType) {
        this.transactionNum = transactionNum;
        this.accNum1 = accNum1;
        this.accNum2 = accNum2;
        this.qty = qty;
        this.date = date;
        this.transactionType = transactionType;
    }

    public int getAccNum1() {
        return accNum1;
    }

    public int getAccNum2() {
        return accNum2;
    }

    @Override
    public String toString() {
        return "com.java.objects.Transaction{" +
                "transactionNum=" + transactionNum +
                ", Sending Account=" + accNum1 +
                ", Receiver Account=" + accNum2 +
                ", Quantity=" + qty +
                ", Date=" + date +
                ", Transaction Type=" + transactionType +
                '}';
    }
}
