package przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone;

import java.util.regex.Pattern;

public class PhoneNumberValidator {

    private static final Pattern pattern = Pattern.compile("[0-9]{7,9}");

    public static boolean validate(String phoneNumber) {
        return pattern.matcher(phoneNumber).matches();
    }
}
