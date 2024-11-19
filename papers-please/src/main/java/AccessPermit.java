import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccessPermit {
    /*
    NAME: Guyovich, Russian
    NATION: Obristan
    ID#: TE8M1-V3N7R
    PURPOSE: TRANSIT
    DURATION: 14 DAYS
    HEIGHT: 159cm
    WEIGHT: 60kg
    EXP: 1983.07.13
     */

    private String name;
    private String nation;
    private String ID;
    private String purpose;
    private Integer duration;
    private Integer height;
    private Integer weight;
    private Date expiryDate;

    public AccessPermit(String rawData) {
        String nameRegex = "NAME: (.*)";
        String nationRegex = "NATION: (.*)";
        String IDRegex = "ID#: (.*)";
        String purposeRegex = "PURPOSE: (.*)";
        String durationRegex = "DURATION: (\\d+) DAYS";
        String heightRegex = "HEIGHT: (\\d+)cm";
        String weightRegex = "WEIGHT: (\\d+)kg";
        String expiryDateRegex = "EXP: (\\d+.\\d+.\\d+)";

        Pattern namePattern = Pattern.compile(nameRegex);
        Pattern nationPattern = Pattern.compile(nationRegex);
        Pattern IDPattern = Pattern.compile(IDRegex);
        Pattern purposePattern = Pattern.compile(purposeRegex);
        Pattern durationPattern = Pattern.compile(durationRegex);
        Pattern heightPattern = Pattern.compile(heightRegex);
        Pattern weightPattern = Pattern.compile(weightRegex);
        Pattern expiryDatePattern = Pattern.compile(expiryDateRegex);

        Matcher nameMatcher = namePattern.matcher(rawData);
        Matcher nationMatcher = nationPattern.matcher(rawData);
        Matcher IDMatcher = IDPattern.matcher(rawData);
        Matcher purposeMatcher = purposePattern.matcher(rawData);
        Matcher durationMatcher = durationPattern.matcher(rawData);
        Matcher heightMatcher = heightPattern.matcher(rawData);
        Matcher weightMatcher = weightPattern.matcher(rawData);
        Matcher expiryDateMatcher = expiryDatePattern.matcher(rawData);

        if (nameMatcher.find()) {
            this.name = nameMatcher.group(1);
        }

        if (nationMatcher.find()) {
            this.nation = nationMatcher.group(1);
        }

        if (IDMatcher.find()) {
            this.ID = IDMatcher.group(1);
        }

        if (purposeMatcher.find()) {
            this.purpose = purposeMatcher.group(1);
        }

        if (durationMatcher.find()) {
            this.duration = Integer.parseInt(durationMatcher.group(1));
        }

        if (heightMatcher.find()) {
            this.height = Integer.parseInt(heightMatcher.group(1));
        }

        if (weightMatcher.find()) {
            this.weight = Integer.parseInt(weightMatcher.group(1));
        }

        if (expiryDateMatcher.find()) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy.MM.dd");

            try {
                this.expiryDate = simpleDateFormat.parse(expiryDateMatcher.group(1));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getName() {
        return name;
    }

    public String getNation() {
        return nation;
    }

    public String getID() {
        return ID;
    }

    public String getPurpose() {
        return purpose;
    }

    public Integer getDuration() {
        return duration;
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
        return "AccessPermit{" +
                "name='" + name + '\'' +
                ", nation='" + nation + '\'' +
                ", ID='" + ID + '\'' +
                ", purpose='" + purpose + '\'' +
                ", duration=" + duration +
                ", height=" + height +
                ", weight=" + weight +
                ", expiryDate=" + expiryDate +
                '}';
    }
}
