package dev.compiani;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileNameExtractor {
    public static String extractFileName(String dirtyFileName) {
        Pattern pattern = Pattern.compile("\\d+_([a-zA-Z0-9_-]+\\.[a-zA-Z0-9_-]+)");
        Matcher matcher = pattern.matcher(dirtyFileName);

        if (!matcher.find()) {
            throw new RuntimeException("Invalid file name");
        }

        return matcher.group(1);
    }
}
