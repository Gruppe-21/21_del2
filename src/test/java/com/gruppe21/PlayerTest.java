package com.gruppe21;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {
    @Test
    public void addPlayerNameTest() {
        Player player = new Player();  // make instance of Player called player
        player.setName("Bob");

        assertEquals("Bob", player.getName());
    }

    @Test
    public void addPlayerNameWithStringTest() {
        Player player = new Player("Bob");  // make instance of Player called player
        assertEquals("Bob", player.getName());
    }

    @Test
    public void nameWithoutSTest() {
        Player player = new Player();  // make instance of Player called player
        player.setName("Bob");

        assertEquals(false, player.isNameEndsWithS());
    }

    @Test
    public void changeNameTest() {
        Player player = new Player();  // make instance of Player called player
        player.setName("Bob");
        player.setName("Clara");

        assertEquals("Clara", player.getName());
    }

    @Test
    public void nameWithSTest() {
        Player player = new Player();  // make instance of Player called player
        player.setName("Louis");


        assertEquals(true, player.isNameEndsWithS());
    }
    @Test
    public void changeNameContainsSTest() {
        Player player = new Player();  // make instance of Player called player
        player.setName("Bob");
        player.setName("Louis");


        assertEquals(true, player.isNameEndsWithS());
    }

    }