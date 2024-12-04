package dev.compiani;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class KataTest {
    @Test
    public void testEmptyString() {
        Map<Character, Integer> d = new HashMap<>();
        assertEquals(d, Kata.count(""));
    }

    @Test
    public void testSingleCharacter() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 1);
        assertEquals(d, Kata.count("a"));
    }

    @Test
    public void testMultipleCharacters() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 3);
        d.put('b', 3);
        d.put('c', 1);
        assertEquals(d, Kata.count("aabbbac"));
    }

    @Test
    public void testAllCharactersUnique() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 1);
        d.put('b', 1);
        d.put('c', 1);
        assertEquals(d, Kata.count("abc"));
    }

    @Test
    public void testAllCharactersSame() {
        Map<Character, Integer> d = new HashMap<>();
        d.put('a', 5);
        assertEquals(d, Kata.count("aaaaa"));
    }

    @Test
    public void testDifferentCharacters() {
        Map<Character, Integer> expected = new HashMap<>();
        expected.put('a', 2);
        expected.put('b', 2);
        Map<Character, Integer> actual = Kata.count("aabb");
        assertEquals(expected, actual);
    }
}