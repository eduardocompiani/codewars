import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GrantOfAsylum {
    /*
        ID#: Y3MNC-TPWQ2
        NATION: United Federation
        NAME: Dolanski, Roman
        DOB: 1933.01.01
        HEIGHT: 176cm
        WEIGHT: 71kg
        EXP: 1983.09.20
     */

    public String ID;
    public String nation;
    public String name;
    public Date birthDate;
    private Integer height;
    private Integer weight;
    public Date expiryDate;

    public GrantOfAsylum(String rawData) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");

        String IDRegex = "ID#: (.*)";
        String nationRegex = "NATION: (.*)";
        String nameRegex = "NAME: (.*)";
        String birthDateRegex = "DOB: (\\d+.\\d+.\\d+)";
        String heightRegex = "HEIGHT: (.*)";
        String weightRegex = "WEIGHT: (.*)";
        String expiryDateRegex = "EXP: (\\d+.\\d+.\\d+)";

        Pattern IDPattern = Pattern.compile(IDRegex);
        Pattern nationPattern = Pattern.compile(nationRegex);
        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern birthDatePattern = Pattern.compile(birthDateRegex);
        Pattern heightPattern = Pattern.compile(heightRegex);
        Pattern weightPattern = Pattern.compile(weightRegex);
        Pattern expiryDatePattern = Pattern.compile(expiryDateRegex);

        Matcher IDMatcher = IDPattern.matcher(rawData);
        Matcher nationMatcher = nationPattern.matcher(rawData);
        Matcher nameMatcher = namePattern.matcher(rawData);
        Matcher birthDateMatcher = birthDatePattern.matcher(rawData);
        Matcher heightMatcher = heightPattern.matcher(rawData);
        Matcher weightMatcher = weightPattern.matcher(rawData);
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

        if (heightMatcher.find()) {
            this.height = Integer.parseInt(heightMatcher.group(1));
        }

        if (weightMatcher.find()) {
            this.weight = Integer.parseInt(weightMatcher.group(1));
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

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    @Override
    public String toString() {
        return "GrantOfAsylum{" +
                "ID='" + ID + '\'' +
                ", nation='" + nation + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", height=" + height +
                ", weight=" + weight +
                ", expiryDate=" + expiryDate +
                '}';
    }
}