package com.gruppe21;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        //Game game = new Game(new Player[] {new Player("Bob Dylan"), new Player("Henning DiCaprio")});
        Game game = new Game(new Player[] {null, null});
        game.startGame();
    }
}

