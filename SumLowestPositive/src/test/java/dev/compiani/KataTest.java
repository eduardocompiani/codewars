package dev.compiani;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KataTest {
    @Test
    public void testKata() {
        assertEquals("numbers = [5, 8, 12, 19, 22]", 13L, Kata.sumTwoSmallestNumbers(new long []{ 5,  8, 12, 19, 22}));
        assertEquals("numbers = [15, 28, 4, 2, 43]",  6L, Kata.sumTwoSmallestNumbers(new long []{15, 28,  4,  2, 43}));
        assertEquals("numbers = [3, 87, 3, 12, 7]",  6L, Kata.sumTwoSmallestNumbers(new long []{ 3, 87,  3, 12,  7}));
        assertEquals("numbers = [23, 71, 33, 82, 1]", 24L, Kata.sumTwoSmallestNumbers(new long []{23, 71, 33, 82,  1}));
        assertEquals("numbers = [52, 76, 14, 12, 4]", 16L, Kata.sumTwoSmallestNumbers(new long []{52, 76, 14, 12,  4}));
    }
}
