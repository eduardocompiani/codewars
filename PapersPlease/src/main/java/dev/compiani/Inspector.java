package dev.compiani;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Inspector {

    private static final List<String> countries = Arrays.asList("Arstotzka", "Antegria", "Impor", "Kolechia", "Obristan", "Republia", "United Federation");
    private static final List<String> allowedCountries = new ArrayList<>();
    private static final List<String> bannedCountries = new ArrayList<>();
    private static boolean requirePassport = false;

    public void receiveBulletin(String bulletin) {
        processBannedCountriesBulletin(bulletin);
        processAllowedCountriesBulletin(bulletin);
        processPassportBulletin(bulletin);

    }

    public String inspect(Map<String, String> rawPersonData) {
        Person person = new Person(rawPersonData);

        System.out.println(person);

        return "";
    }

    private void processBannedCountriesBulletin(String bulletin) {
        //Deny citizens of Kolechia, Republia
        String regex = "Deny citizens of (.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bulletin);

        if (matcher.find()) {
            allowedCountries.addAll(Arrays.asList(matcher.group(1).split(", ")));
        }
    }

    private void processAllowedCountriesBulletin(String bulletin) {
        String regex = "Allow citizens of (.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bulletin);

        if (matcher.find()) {
            bannedCountries.addAll(Arrays.asList(matcher.group(1).split(", ")));
        }
    }

    private void processPassportBulletin(String bulletin) {
        String regex = "Entrants require passport";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bulletin);

        requirePassport = matcher.find();
    }

}