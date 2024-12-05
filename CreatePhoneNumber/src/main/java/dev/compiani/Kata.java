package dev.compiani;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        return Arrays.stream(numbers).mapToObj(String::valueOf).collect(Collectors.joining("")).replaceAll("(\\d{3})(\\d{3})(\\d{4})", "($1) $2-$3");
    }
}
