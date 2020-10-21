package com.gruppe21;

public class BankBalance {

    private int balance = 0; // Player has 3000 as starting balance


    public int getBankBalance(){
        return balance;
    }

    public int setBankBalance(int amount){
        this.balance = balance;
    }

    // add paramter amount to current balance
    public void addBankBalance(int amount) {
        setBankBalance(getBankBalance() + amount);
    }

    public void removeBankBalance(int amount){
        setBankBalance(getBankBalance() - amount);
    }


}
