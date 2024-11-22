package dev.compiani;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {
    /*
        ID#: GC07D-FU8AR
        NATION: Arstotzka
        NAME: Costanza, Josef
        DOB: 1933.11.28
        SEX: M
        ISS: East Grestin
        EXP: 1983.03.15
     */

    public String ID;
    public String nation;
    public String name;
    public Date birthDate;
    public String gender;
    public String iss;
    public Date expiryDate;

    public Passport(String rawData) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");

        String IDRegex = "ID#: (.*)";
        String nationRegex = "NATION: (.*)";
        String nameRegex = "NAME: (.*)";
        String birthDateRegex = "DOB: (\\d+.\\d+.\\d+)";
        String genderRegex = "SEX: (.*)";
        String issRegex = "ISS: (.*)";
        String expiryDateRegex = "EXP: (\\d+.\\d+.\\d+)";

        Pattern IDPattern = Pattern.compile(IDRegex);
        Pattern nationPattern = Pattern.compile(nationRegex);
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern birthDatePattern = Pattern.compile(birthDateRegex);
        Pattern genderPattern = Pattern.compile(genderRegex);
        Pattern issPattern = Pattern.compile(issRegex);
        Pattern expiryDatePattern = Pattern.compile(expiryDateRegex);

        Matcher IDMatcher = IDPattern.matcher(rawData);
        Matcher nationMatcher = nationPattern.matcher(rawData);
        Matcher nameMatcher = namePattern.matcher(rawData);
        Matcher birthDateMatcher = birthDatePattern.matcher(rawData);
        Matcher genderMatcher = genderPattern.matcher(rawData);
        Matcher issMatcher = issPattern.matcher(rawData);
        Matcher expiryDateMatcher = expiryDatePattern.matcher(rawData);

        if (IDMatcher.find()) {
            this.ID = IDMatcher.group(1);
        }

        if (nationMatcher.find()) {
            this.nation = nationMatcher.group(1);
        }

        if (nameMatcher.find()) {
            this.name = nameMatcher.group(1);
        }

        if (birthDateMatcher.find()) {
            try {
                this.birthDate = simpleDateFormat.parse(birthDateMatcher.group(1));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }

        if (genderMatcher.find()) {
            this.gender = genderMatcher.group(1);
        }

        if (issMatcher.find()) {
            this.iss = issMatcher.group(1);
        }

        if (expiryDateMatcher.find()) {
            try {
                this.expiryDate = simpleDateFormat.parse(expiryDateMatcher.group(1));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getID() {
        return ID;
    }

    public String getNation() {
        return nation;
    }

    public String getName() {
        return name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getGender() {
        return gender;
    }

    public String getIss() {
        return iss;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "ID='" + ID + '\'' +
                ", nation='" + nation + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender='" + gender + '\'' +
                ", iss='" + iss + '\'' +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
