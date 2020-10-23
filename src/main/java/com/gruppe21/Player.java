package com.gruppe21;

public class Player {
    private String name = "";            // The player's name
    private BankBalance bankBalance;        // The player's bank balance
    //private boolean toSekserer = false;  // Checks whether or not the player played two 6
    private boolean nameEndsWithS;     // Checks whether or not the the player's name ends with a "s"
    private int currentSquareIndex;

    public Player(String name){
        setName(name);
        bankBalance = new BankBalance();
    }
    public Player(){
    }

    // Gets the bank balance
    public BankBalance getBankBalance() {
        return bankBalance;
    }

    // Sets the player's point to a given int
    public void setBankBalance(BankBalance bankBalance) {
        this.bankBalance = bankBalance;
    }


    //public boolean isToSekserer() {return toSekserer;}

    //public void setToSekserer(boolean toSekserer) {this.toSekserer = toSekserer;}

    // Gets the player's name as a string
    public String getName() {
        return name;
    }

    // Sets the player's name
    public void setName(String name) {
        this.name = name;
        nameEndsWithS = getName().toLowerCase().endsWith("s");
    }
    // Checks if the player's name ends with a "s"
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

