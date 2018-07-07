package przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.pesel.PeselValidator;

@RunWith(JUnit4.class)
public class PhoneNumberValidatorTest {

    @Test
    public void validatesCorrectNumber() {
        Assert.assertEquals(true, PhoneNumberValidator.validate("1234567"));
        Assert.assertEquals(true, PhoneNumberValidator.validate("123456789"));
    }

    @Test
    public void validateFailsOnNonDigits() {
        Assert.assertEquals(false, PhoneNumberValidator.validate("123456s8901"));
    }

    @Test
    public void validateFailOnWrongLength() {
        Assert.assertEquals(false, PhoneNumberValidator.validate("123450"));
        Assert.assertEquals(false, PhoneNumberValidator.validate("123456789011"));
    }
}
