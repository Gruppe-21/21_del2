package com.gruppe21;

public class Player {
    private static final int MAX_NAME_LENGTH = 50;

    private String name = "";            // spillers navn
    private BankBalance bankBalance;        // spillers point
    //private boolean toSekserer = false;  // tjekker om spiller har to seksere
    private boolean nameEndsWithS;     // tjekker om navn slutter med s
    private int currentSquareIndex;

    public Player(String name){
        setName(name);
        initPlayer();
    }
    public Player(){
        initPlayer();
    }

    private void initPlayer(){
        bankBalance = new BankBalance();
        currentSquareIndex = 0;
    }

    // hent point værdi
    public BankBalance getBankBalance() {
        return bankBalance;
    }

    // sætter spillers point til givne int
    public void setBankBalance(BankBalance bankBalance) {
        this.bankBalance = bankBalance;
    }


    //public boolean isToSekserer() {return toSekserer;}

    //public void setToSekserer(boolean toSekserer) {this.toSekserer = toSekserer;}

    // hent navn som string
    public String getName() {
        return name;
    }

    // sæt navn
    public boolean setName(String name) {
        if (name.length() > MAX_NAME_LENGTH) return false;

        this.name = name;
        nameEndsWithS = getName().toLowerCase().endsWith("s");
        return true;
    }

    public boolean isNameEndsWithS() {
        return nameEndsWithS;
    }

    // examines which square the player is on
    public void setCurrentSquareIndex(int currentSquareIndex){
        this.currentSquareIndex = currentSquareIndex;
    }

    public int getCurrentSquareIndex(){
        return currentSquareIndex;
    }
}

