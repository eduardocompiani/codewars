package dev.compiani;

import org.junit.Test;

import static org.junit.Assert.*;

public class SquareTest {
    @Test
    public void testNegative() {
        assertFalse("negative numbers aren't square numbers", Square.isSquare(-1));
    }

    @Test
    public void testZero() {
        assertTrue("0 is a square number (0 * 0)", Square.isSquare(0));
    }

    @Test
    public void testTree() {
        assertFalse("3 isn't a square number", Square.isSquare(3));
    }

    @Test
    public void testFour() {
        assertTrue("4 is a square number (2 * 2)", Square.isSquare(4));
    }

    @Test
    public void testFive() {
        assertTrue("25 is a square number (5 * 5)", Square.isSquare(25));
    }

    @Test
    public void testRandom() {
        assertFalse("26 isn't a square number", Square.isSquare(26));
    }
}
