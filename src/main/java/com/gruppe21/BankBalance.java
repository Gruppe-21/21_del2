package com.gruppe21;

public class BankBalance {

    private int balance = 1000; // Player has 1000 as starting balance


    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        if (balance < 0) balance = 0;
        this.balance = balance;
    }

    /**
     * add value of parameter "amount" to current balance
     * @param amount
     * @return getBalance() new balance
     */
    public int addBalance(int amount) {
        setBalance(getBalance() + amount);
        return getBalance();
    }

}
