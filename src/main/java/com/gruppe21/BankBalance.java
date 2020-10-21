package com.gruppe21;

public class BankBalance {

    private int balance = 0; // Player has 3000 as starting balance


    public int getBankBalance(){
        return balance;
    }

    public void setBankBalance(int balance){
        this.balance = balance;
    }

    // add value of parameter "amount" to current balance
    public int addBankBalance(int amount) {
        setBankBalance(getBankBalance() + amount);
        return balance;
    }

    // remove value of parameter "amount" from current balance
    // uses Math.abs to get the postive value of int
    public int removeBankBalance(int amount) {
        setBankBalance(getBankBalance() - Math.abs(amount));
        return balance;
    }

}
