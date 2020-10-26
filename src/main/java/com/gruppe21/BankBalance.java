package com.gruppe21;

public class BankBalance {

    private int balance = 1000; // Player has 1000 as starting balance


    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
        if (balance < 0) balance = 0;
    }

    // add value of parameter "amount" to current balance
    public int addBalance(int amount) {
        setBalance(getBalance() + amount);
        return getBalance();
    }

}
