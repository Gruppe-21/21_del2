package com.gruppe21;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void squareReturnsEventText() {
        Square sq = new Square("place", "Hello World!", 1000);

        Assert.assertEquals("Hello World!", sq.eventText);
    }

    @Test
    public void squareModifiesPlayerBalance() {
        Player player = new Player();
        Square sq = new Square("place", "Hello World!", 1000);

        // TODO implement test for checking if square modifies a players bank balance
    }
}