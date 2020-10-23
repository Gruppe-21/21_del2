package com.gruppe21;

import com.gruppe21.gui.GUIWrapper;

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

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    private GUIWrapper guiWrapper;
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

        guiWrapper = new GUIWrapper();
        guiWrapper.reloadGUI(board.getSquares());
        guiWrapper.addPlayer(players[0]);
        guiWrapper.addPlayer(players[1]);
    }


    public boolean playRound() {
        System.out.println(players[currentPlayer].getName() + (players[currentPlayer].isNameEndsWithS() ? "'" : "'s") + " turn! " +
                "Your balance is ¤" + players[currentPlayer].getBankBalance().getBalance() + "\n" +
                "Press Enter to roll your " + (dice.length > 1 ? "dice" : "die"));
        waitForUserInput();
        guiWrapper.setDice(dice[0].getValue(), dice[1].getValue());

        int sum = 0;
        for (Die die : dice) {
            sum += die.getValue();
        }
        movePlayer(currentPlayer, board.getSquareAtNumber(sum));


        Square squareLandedOn = board.getSquareAtNumber(sum);
        squareLandedOn.handleEvent(players[currentPlayer], guiWrapper);
        if (players[currentPlayer].getBankBalance().getBalance() >= 3000) {
            return true;
        }
        if (squareLandedOn.getSquareType() != SquareType.ExtraTurn) {
            currentPlayer = nextPlayer();
        }
        return false;
    }

    public void startGame(){
        do {
            for (Die die : dice) {
                die.rollDie();
            }
        }while (!playRound());
        Player winner = players[currentPlayer];
        guiWrapper.showMessage(winner.getName() + " has reached ¤" + winner.getBankBalance().getBalance()
                                + " and won the game");
    }

    private void movePlayer(int playerIndex, Square square){
        guiWrapper.movePlayer(playerIndex, players[playerIndex].getCurrentSquareIndex(), board.getSquareIndex(square) );
    }

    private int nextPlayer() {
        return (currentPlayer + 1) % players.length;
    }

    private void waitForUserInput(){
        if (isTest) return;
        guiWrapper.getButtonPress("Roll " + ( (dice.length > 1) ? "dice" : "die"));
    }
}
