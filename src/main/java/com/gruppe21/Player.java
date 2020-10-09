package com.gruppe21;

public class Player {


    private String name = "";            // spillers navn
    private int bankBalance = 1000;        // spillers point
    //private boolean toSekserer = false;  // tjekker om spiller har to seksere
    private boolean nameEndsWithS;     // tjekker om navn slutter med s
    private int currentSquareIndex;

    public Player(String name){
        setName(name);
    }
    public Player(){
    }

    // hent point værdi
    public int getBankBalance() {
        return bankBalance;
    }

    // sætter spillers point til givne int
    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }


    //public boolean isToSekserer() {return toSekserer;}

    //public void setToSekserer(boolean toSekserer) {this.toSekserer = toSekserer;}

    // hent navn som string
    public String getName() {
        return name;
    }

    // sæt navn
    public void setName(String name) {
        this.name = name;
        nameEndsWithS = getName().toLowerCase().endsWith("s");
    }

    public boolean isNameEndsWithS() {
        return nameEndsWithS;
    }

    // tilføj point
    public void addPoint(int i){
        setBankBalance(getBankBalance() + i);
    }

    // examines which square the player is on
    public void setCurrentSquareIndex(int currentSquareIndex){
        this.currentSquareIndex = currentSquareIndex;
    }

    public int getCurrentSquareIndex(){
        return currentSquareIndex;
    }
}
