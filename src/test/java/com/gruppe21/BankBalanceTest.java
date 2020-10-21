package com.gruppe21;

import static org.junit.Assert.*;
import org.junit.Test;

public class BankBalanceTest extends BankBalance {

    @Test
    public void addBankBalance(){
        BankBalance bankBalance = new BankBalance(); // make instance of BankBalance called bankBalance
        int amount = 100;

        int currentBalance = bankBalance.addBankBalance(amount); // call addBankBalance on bankBalance

        assertEquals(100,currentBalance);
    }

    @Test
    public void removeBankBalance(){
        BankBalance bankBalance = new BankBalance();
        bankBalance.setBankBalance(150);             // BankBalance set to 200
        int amount = -100;

        int currentBalance = bankBalance.removeBankBalance(amount); // call removeBankBalance on bankBalance

        assertEquals(50,currentBalance);
    }


}