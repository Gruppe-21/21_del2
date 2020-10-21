package com.gruppe21;

import static org.junit.Assert.*;
import org.junit.Test;

public class BankBalanceTest extends BankBalance {

    @Test
    public void addBankBalance(){
        BankBalance bankBalance = new BankBalance();
        int amount = 100;

        int currentBalance = bankBalance.addBankBalance(amount);

        assertEquals(100,currentBalance);
    }

    @Test
    public void removeBankBalance(int amount){

        assertEquals();
    }



}