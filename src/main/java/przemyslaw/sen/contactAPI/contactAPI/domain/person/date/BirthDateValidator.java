package przemyslaw.sen.contactAPI.contactAPI.domain.person.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BirthDateValidator {

    private static final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    public static boolean validate(Date date) throws ParseException {
        return (
                //TODO: this date should be parametrized
                date.after(dateFormatter.parse("01/01/1918")) &&
                date.before(new Date())
        );
    }
}
