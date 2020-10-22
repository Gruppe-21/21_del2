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

    // remove value of parameter "amount" from current balance
    // uses Math.abs to get the numerical value of int
    // balance cannot be of negative value
    public int removeBalance(int amount) {
        setBalance(getBalance() - Math.abs(amount));
            return getBalance();
    }

}
