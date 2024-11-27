package dev.compiani;

public class Solution {
    public static String camelCase(String text) {
        return text.replaceAll("([A-Z])", " $1");
    }
}
