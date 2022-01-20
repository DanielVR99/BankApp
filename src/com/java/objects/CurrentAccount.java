package com.java.objects;

public class CurrentAccount extends Account{
    private float money;

    public CurrentAccount(int accountNumber, int clientNum, float money) {
        super(accountNumber, clientNum, "Current");
        this.money = money;
    }

    @Override
    public String toString() {
        return "com.java.objects.CurrentAccount{" +
                "money=" + money +
                ", accountNumber=" + super.getAccountNumber() +
                ", accountType=" + super.getAccountType() +
                '}';
    }

    public float getMoney() {
        return money;
    }

    public void addMoney(float add){
        this.money += add;
    }

    public void takeMoney(float take){
        this.money -= take;
    }
}
