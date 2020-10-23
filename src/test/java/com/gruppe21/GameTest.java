package com.gruppe21;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {


    @Test
    public void playRoundPlayerCanWin() {
        Player[] players = new Player[]{new Player("Player1"), new Player("Player2")};
        Die[] dice = new Die[]{new Die(), new Die()};
        Game game = new Game(players, dice, true);

        players[0].getBankBalance().setBalance(2999);
        dice[0].setValue(1);
        dice[1].setValue(1);
        Assert.assertEquals(true, game.playRound());
        Assert.assertEquals(players[0], game.getPlayers()[game.getCurrentPlayer()]);
    }

    @Test
    public void startGameTest() {

        assertEquals(3000, players[0].getBankBalance());

    }
}