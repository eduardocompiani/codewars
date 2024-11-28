package dev.compiani;

public class Kata {
    public static String[] towerBuilder(int nFloors)
    {
        String[] tower = new String[nFloors];

        for (int floor = 0; floor < nFloors; floor++) {
            String whiteSpaces = " ".repeat(nFloors - 1 - floor);
            String stars = "*".repeat((floor * 2) + 1);
            tower[floor] = whiteSpaces + stars + whiteSpaces;
        }

        return tower;
    }
}
