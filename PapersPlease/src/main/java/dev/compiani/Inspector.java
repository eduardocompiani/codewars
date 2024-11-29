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

        try {
            checkPassport(person);
            checkID(person);
            checkAllowedCountry(person);
        } catch (RuntimeException e) {
            return e.getMessage();
        }

        if (person.isCitizen()) {
            return "Glory to Arstotzka.";
        }

        return "Cause no trouble.";
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

    private String documentRequired(String document) {
        return "Entry denied: missing required " + document + ".";
    }

    private void checkPassport(Person person) {
        if (requirePassport && person.getPassport() == null) {
            throw new RuntimeException(documentRequired("passport"));
        }
    }

    private void checkID(Person person) {
        List<String> IDs = new ArrayList<>();

        if (person.getPassport() != null) {
            IDs.add(person.getPassport().getID());
        }

        if (person.getAccessPermit() != null) {
            IDs.add(person.getAccessPermit().getID());
        }

        if (person.getGrantOfAsylum() != null) {
            IDs.add(person.getGrantOfAsylum().getID());
        }

        if (!IDs.stream().allMatch(id -> id.equals(IDs.get(0)))) {
            throw new RuntimeException("Detainment: ID number mismatch.");
        }
    }

    private void checkAllowedCountry(Person person) {
        if (allowedCountries.isEmpty()) {
            return;
        }

        if (person.getPassport() != null && allowedCountries.contains(person.getPassport().getNation())) {
            return;
        }

        if (person.getAccessPermit() != null && allowedCountries.contains(person.getAccessPermit().getNation())) {
            return;
        }

        if (person.getGrantOfAsylum() != null && allowedCountries.contains(person.getGrantOfAsylum().getNation())) {
            return;
        }

        throw new RuntimeException("Entry denied: citizen of banned nation.");
    }

}