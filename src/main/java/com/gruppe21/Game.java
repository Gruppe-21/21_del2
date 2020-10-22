package com.gruppe21;

import java.util.Scanner;

public class Game {

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public Die[] getDice() {
        return dice;
    }

    public void setDice(Die[] dice) {
        this.dice = dice;
    }

    private Board board;
    private Player[] players;
    private int currentPlayer;
    private Die[] dice;

    private Scanner scanner;
    private boolean isTest;


    public Game(Player[] players) {
        initGame(players, new Die[] {new Die(), new Die()}, false);
    }

    public Game(Player[] players, Die[] dice) {
        initGame(players, dice, false);
    }

    public Game(Player[] players, Die[] dice, boolean isTest) {
        initGame(players, dice, isTest);
    }

    private void initGame(Player[] players, Die[] dice, boolean isTest){
        board = new Board();
        this.players = players;
        this.dice = dice;
        scanner = new Scanner(System.in);
        this.isTest = isTest;
    }

    public boolean playRound(){
        System.out.println(players[currentPlayer].getName() + (players[currentPlayer].isNameEndsWithS() ? "'" : "'s") + " turn! " +
                "Your balance is ¤" + players[currentPlayer].getBankBalance().getBalance() + "\n" +
                "Press Enter to roll your " + (dice.length > 1 ? "dice" : "die"));
        waitForUserInput();

        String strPrintRoll = "";
        int sum = 0;
        for (Die die : dice) {
            sum += die.rollDie();
            strPrintRoll += die + ", ";
        }
        strPrintRoll = strPrintRoll.substring(0, strPrintRoll.length() - 3);
        System.out.println("You've rolled: " + strPrintRoll);

        Square squareLanedOn = board.getSquareAtNumber(sum);
        squareLanedOn.handleEvent(players[currentPlayer]);
        if (players[currentPlayer].getBankBalance().getBalance() >= 3000){
            return true;
        }
        if (squareLanedOn.getSquareType() != SquareType.ExtraTurn){
            currentPlayer = nextPlayer();
        }
        return false;
    }

    public void startGame(){
        while (!playRound()){

        }
        Player winner = players[currentPlayer];
        System.out.println(winner.getName() + " has reached ¤" + winner.getBankBalance().getBalance()
                            + " and won the game");
    }

    private int nextPlayer() {
        return (currentPlayer + 1) % players.length;
    }

    private void waitForUserInput(){
        if (isTest) return;
        if (scanner.nextLine().trim().equalsIgnoreCase("exit")){
            //end game
        }
    }
}
