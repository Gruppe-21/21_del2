package com.gruppe21;

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

    private Player[] players;
    private Die[] dice;


    public Game(Player[] players) {
        this.players = players;
        dice = new Die[] {new Die(), new Die()};
    }

    public Game(Player[] players, Die[] dice) {
        this.players = players;
        this.dice = dice;
    }
}
