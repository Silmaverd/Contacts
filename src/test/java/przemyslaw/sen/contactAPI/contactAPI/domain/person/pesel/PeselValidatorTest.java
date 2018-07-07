package przemyslaw.sen.contactAPI.contactAPI.domain.person.pesel;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PeselValidatorTest {

    @Test
    public void validatesCorrectPesel() {
        Assert.assertEquals(true, PeselValidator.validate("12345678901"));
    }

    @Test
    public void validateFailsOnNonDigits() {
        Assert.assertEquals(false, PeselValidator.validate("123456s8901"));
    }

    @Test
    public void validateFailOnWrongLength() {
        Assert.assertEquals(false, PeselValidator.validate("1234567890"));
        Assert.assertEquals(false, PeselValidator.validate("123456789011"));
    }
}
