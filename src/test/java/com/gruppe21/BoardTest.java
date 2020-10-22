package com.gruppe21;

import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void getSquareAtNumberReturnsTower() {
        Board board = new Board();

        assertEquals("Tower", board.getSquareAtNumber(2).getName());
    }

    @Test
    public void getSquareAtNumberReturnsWereWall() {
        Board board = new Board();

        assertEquals("The Werewall", board.getSquareAtNumber(10).getName());
    }

    @Test
    public void getSquareAtNumberReturnsNullAtLessThanOne() {
        Board board = new Board();

        assertEquals(null, board.getSquareAtNumber(1));

    }

}