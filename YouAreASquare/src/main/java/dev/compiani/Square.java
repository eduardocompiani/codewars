package dev.compiani;

public class Square {
    public static boolean isSquare(int x) {
        if (x == 0) return true;

        try {
            Integer.parseInt(Double.toString(Math.sqrt(x)));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
