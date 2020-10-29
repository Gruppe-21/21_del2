package com.gruppe21;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        // Start new game without predefined players
        Game game = new Game(new Player[] {null, null});
        game.startGame();
    }
}

