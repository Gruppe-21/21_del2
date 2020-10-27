package com.gruppe21;

import com.gruppe21.gui.GUIWrapper;

import java.awt.*;
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


    public Game(Player[] players) {
        initGame(players, new Die[] {new Die(), new Die()});
    }

    public Game(Player[] players, Die[] dice) {
        initGame(players, dice);
    }

    private void initGame(Player[] players, Die[] dice) {
        board = new Board();
        this.players = players;
        this.dice = dice;
        scanner = new Scanner(System.in);

        guiWrapper = new GUIWrapper();
        guiWrapper.reloadGUI(board.getSquares());

        //It is insured that all player != null and all players have a name
        for (int i = 0; i < players.length; i++) {
            if (players[i] == null) players[i] = new Player();

            while (players[i].getName().isEmpty()) {
                try {
                    String providedPlayerName = guiWrapper.getStringInput("Please write your name, Player" + (i + 1) + " (Leave empty for a random name)");

                    //To-Do: Read names from file
                    //Should at least be its own method mabye even its own class if it was more complicated
                    if (providedPlayerName.isEmpty()) providedPlayerName = new String[] {
                                    "Admiral Akbar", "Henning DiCaprio", "Paulo", "X Æ A-12", "John Cena", "John Smith",
                                    "Galadriel", "Elrond", "Gandalf the Grey", "Saruman the White", "Frodo Baggins", "Samwise Gamgee",
                                    "Bilbo Baggins"
                                    } [ (int)(Math.random() * 13 + 1)];

                    if (!players[i].setName(providedPlayerName.trim()) || players[i].getName().isEmpty()) guiWrapper.showMessage("Invalid name");
                } catch (Exception e) {
                    guiWrapper.showMessage("An error has occurred.");
                }
            }

        }

        guiWrapper.addPlayer(players[0], Color.RED);
        guiWrapper.addPlayer(players[1], Color.BLUE);
        guiWrapper.getButtonPress("Welcome to Rejsen til Kolding. Press start to begin!", "Start");
    }

    public boolean playRound() {
        waitForUserInput(players[currentPlayer].getName() + (players[currentPlayer].isNameEndsWithS() ? "'" : "'s") + " turn! ");
        guiWrapper.setDice(dice[0].getValue(), dice[1].getValue());

        int sum = 0;
        for (Die die : dice) {
            sum += die.getValue();
        }
        movePlayer(currentPlayer, board.getSquareAtNumber(sum));

        Square squareLandedOn = board.getSquareAtNumber(sum);
        squareLandedOn.handleEvent(players[currentPlayer], guiWrapper);
        guiWrapper.updatePlayerBalance(currentPlayer, players[currentPlayer].getBankBalance().getBalance());
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
        guiWrapper.getButtonPress("The game will now close.", "That's fine'");
        guiWrapper.close();
    }

    private void movePlayer(int playerIndex, Square square){
        int squareIndex = board.getSquareIndex(square);
        guiWrapper.movePlayer(playerIndex, players[playerIndex].getCurrentSquareIndex(), squareIndex );
        players[playerIndex].setCurrentSquareIndex(squareIndex);
    }

    private int nextPlayer() {
        return (currentPlayer + 1) % players.length;
    }

    private void waitForUserInput(String message){
        guiWrapper.getButtonPress(message, "Roll");
    }
}
