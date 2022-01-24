package com.java.dao;

import com.java.objects.Account;

import java.util.ArrayList;

public class AccountDAO {
    private ArrayList<Account> accounts = new ArrayList<Account>();

    public void addAccount(Account account){
        accounts.add(account);
    }

    public void deleteAcc(Account account){
        accounts.remove(account);
    }

    public Account getAccount(int cuenta){
        return accounts.get(cuenta);
    }

    public ArrayList<Account> getAccounts(){
        return this.accounts;
    }

    public void replaceAccount(Account acc1){
        for (Account acc : accounts){
            if(acc.getAccountNumber() == acc1.getAccountNumber()){
                acc = acc1;
            }
        }
    }

    public int getSize(){
        return accounts.size();
    }
}
