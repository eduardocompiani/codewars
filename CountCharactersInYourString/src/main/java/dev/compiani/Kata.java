package dev.compiani;

import java.util.HashMap;
import java.util.Map;

public class Kata {
    public static Map<Character, Integer> count(String str) {
        Map<Character, Integer> result = new HashMap<>();
        str.chars().mapToObj(c -> (char) c).forEach(c -> result.put(c, result.getOrDefault(c, 0) + 1));
        return result;
    }
}
