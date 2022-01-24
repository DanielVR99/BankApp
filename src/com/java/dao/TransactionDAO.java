package com.java.dao;

import com.java.objects.Transaction;

import java.util.ArrayList;

public class TransactionDAO {

    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public void addTransaction(Transaction add){
        this.transactions.add(add);
    }

    public int getTransactionNum(){
        return transactions.size();
    }
}
