package przemyslaw.sen.contactAPI.contactAPI.domain.contact.email;

import java.util.regex.Pattern;

public class EmailValidator {

    // pattern copied from Internet
    private static final Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

    public static boolean validate(String address) {
        return pattern.matcher(address).matches();
    }
}
