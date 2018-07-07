package przemyslaw.sen.contactAPI.contactAPI.domain.person.pesel;

import java.util.regex.Pattern;

public class PeselValidator {

    private static final Pattern pattern = Pattern.compile("[0-9]{11}");

    public static Boolean validate(String peselNumber) {
        return pattern.matcher(peselNumber).matches();
    }
}
