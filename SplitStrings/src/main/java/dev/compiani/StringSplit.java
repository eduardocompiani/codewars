package dev.compiani;

import java.util.ArrayList;
import java.util.List;

public class StringSplit {
    public static String[] solution(String str) {
        List<String> list = new ArrayList<>();
        if (str.length() % 2 == 1) {
            str += "_";
        }

        for (int i = 0; i < str.length() / 2; i++) {
            list.add(str.substring(i*2, (i*2) + 2));
        }

        return list.toArray(new String[0]);
    }
}
