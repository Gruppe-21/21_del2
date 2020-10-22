package com.gruppe21;

public class BankBalance {

    private int balance = 1000; // Player has 1000 as starting balance


    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    // add value of parameter "amount" to current balance
    public int addBankBalance(int amount) {
        setBalance(getBalance() + amount);
        return balance;
    }

    // remove value of parameter "amount" from current balance
    // uses Math.abs to get the numerical value of int
    // balance cannot be of negative value
    public int removeBankBalance(int amount) {
        setBalance(getBalance() - Math.abs(amount));
        if (balance < 0){
            setBalance(0);
            return balance;
        } else {
            return balance;
        }
    }

}
