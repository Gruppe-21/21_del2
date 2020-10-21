package com.gruppe21;

import static org.junit.Assert.*;
import org.junit.Test;

public class BankBalanceTest {

    @Test
    public void addBankBalanceTest(){
        BankBalance bankBalance = new BankBalance(); // make instance of BankBalance called bankBalance
        bankBalance.setBankBalance(3000);            // BankBalance set to 3000
        int amount = 100;

        int currentBalance = bankBalance.addBankBalance(amount); // call addBankBalance on bankBalance

        assertEquals(3100,currentBalance);
    }

    @Test
    public void removeBankBalanceTest(){
        BankBalance bankBalance = new BankBalance();
        bankBalance.setBankBalance(3000);           // BankBalance set to 3000
        int amount = -100;

        int currentBalance = bankBalance.removeBankBalance(amount); // call removeBankBalance on bankBalance

        assertEquals(2900,currentBalance);
    }

    @Test
    public void removeBankBalanceZeroTest(){
        BankBalance bankBalance = new BankBalance();
        bankBalance.setBankBalance(50);             // BankBalance set to 50
        int amount = -100;

        int currentBalance = bankBalance.removeBankBalance(amount); // call removeBankBalance on bankBalance

        assertEquals(0,currentBalance);
    }


}