package dev.compiani;

public class Main {
    public static void main(String[] args) {
        if (!Square.isSquare(-1)) {
            System.out.println("negative numbers aren't square numbers");
        }
        if (Square.isSquare(0)) {
            System.out.println("0 is a square number (0 * 0)");
        }
        if (!Square.isSquare(3)) {
            System.out.println("3 isn't a square number");
        }
        if (Square.isSquare(4)) {
            System.out.println("4 is a square number (2 * 2)");
        }
        if (Square.isSquare(25)) {
            System.out.println("25 is a square number (5 * 5)");
        }
        if (!Square.isSquare(26)) {
            System.out.println("26 isn't a square number");
        }
    }
}