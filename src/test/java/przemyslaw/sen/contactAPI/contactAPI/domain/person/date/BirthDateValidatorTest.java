package przemyslaw.sen.contactAPI.contactAPI.domain.person.date;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.text.ParseException;
import java.text.SimpleDateFormat;

@RunWith(JUnit4.class)
public class BirthDateValidatorTest {

    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void validatesForCorrectDate() throws ParseException {
        Assert.assertEquals(true, BirthDateValidator.validate(dateFormatter.parse("01/01/2000")));
    }

    @Test
    public void validateFailsForFutureDates() throws ParseException {
        Assert.assertEquals(false, BirthDateValidator.validate(dateFormatter.parse("01/01/2100")));
    }

    @Test
    public void validateFailsForDatesBeforeTheWorld() throws ParseException {
        Assert.assertEquals(false, BirthDateValidator.validate(dateFormatter.parse("01/01/1900")));
    }
}
