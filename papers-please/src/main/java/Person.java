import java.util.Map;

public class Person {
    private AccessPermit accessPermit;
    private Passport passport;
    private GrantOfAsylum grantOfAsylum;

    public Person(Map<String, String> rawData) {
        accessPermit = null;
        passport = null;
        grantOfAsylum = null;

        if (rawData.containsKey("access_permit")) {
            accessPermit = new AccessPermit(rawData.get("access_permit"));
        }

        if (rawData.containsKey("passport")) {
            passport = new Passport(rawData.get("passport"));
        }

        if (rawData.containsKey("grant_of_asylum")) {
            grantOfAsylum = new GrantOfAsylum(rawData.get("grant_of_asylum"));
        }
    }
}
