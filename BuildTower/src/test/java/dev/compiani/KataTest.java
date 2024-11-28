package dev.compiani;

import org.junit.Test;

import static org.junit.Assert.*;

public class KataTest {

    @Test
    public void testOne() {
        assertEquals(String.join(",", "*"), String.join(",", Kata.towerBuilder(1)));
    }

    @Test
    public void testTwo() {
        assertEquals(String.join(",", " * ", "***"), String.join(",", Kata.towerBuilder(2)));
    }

    @Test
    public void testThree() {
        assertEquals(String.join(",", "  *  ", " *** ", "*****"), String.join(",", Kata.towerBuilder(3)));
    }
}