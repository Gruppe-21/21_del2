package com.gruppe21;

import static org.junit.Assert.*;
import org.junit.Test;

public class BankBalanceTest extends BankBalance {

    @Test
    public void addBankBalancePositiveAmountTest(){
        BankBalance bankBalance = new BankBalance(); // make instance of BankBalance called bankBalance
        int amount = 100;

        bankBalance.addBalance(amount); // call addBalance on BankBalance

        assertEquals(1100,bankBalance.getBalance());
    }

    @Test
    public void addBankBalanceNegativeAmountTest(){
        BankBalance bankBalance = new BankBalance(); // make instance of BankBalance called bankBalance
        int amount = -100;

        bankBalance.addBalance(amount); // call addBalance on BankBalance

        assertEquals(900,bankBalance.getBalance());
    }

    @Test
    public void addBankBalanceZeroTest(){
        BankBalance bankBalance = new BankBalance();
        bankBalance.setBalance(50);             // bankBalance set to 50
        int amount = -100;

        bankBalance.addBalance(amount); // call addBalance on bankBalance

        assertEquals(0,bankBalance.getBalance());
    }

}