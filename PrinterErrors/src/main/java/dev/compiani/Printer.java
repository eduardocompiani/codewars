package dev.compiani;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Printer {
    public static String printerError(String s) {
        int size = s.length();
        int errors = 0;

        String successRegex = "[n-z]";
        Pattern successPattern = Pattern.compile(successRegex);
        Matcher successMatcher = successPattern.matcher(s);

        while (successMatcher.find()) {
            errors++;
        }

        return errors + "/" + size;
    }
}
