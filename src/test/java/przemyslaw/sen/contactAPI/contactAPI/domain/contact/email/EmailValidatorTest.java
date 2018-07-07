package przemyslaw.sen.contactAPI.contactAPI.domain.contact.email;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class EmailValidatorTest {

    @Test
    public void validatesCorrectEmails(){
        Assert.assertEquals(true, EmailValidator.validate("aaa.bbbb@abc.com"));
        Assert.assertEquals(true, EmailValidator.validate("aaa.bbbb@abc.pl"));
        Assert.assertEquals(true, EmailValidator.validate("aaabbbb@abc.com"));
        Assert.assertEquals(true, EmailValidator.validate("aaa.bb.bb@abc.com"));
        Assert.assertEquals(true, EmailValidator.validate("aaa.bb-bb@abc.com"));
        Assert.assertEquals(true, EmailValidator.validate("aaa.b19bb@abc.com"));
        Assert.assertEquals(true, EmailValidator.validate("aaa.bb-11bb@abc.com"));
    }

    @Test
    public void failsOnIncorrectEmails(){
        Assert.assertEquals(false, EmailValidator.validate("aaa.bbbb@abc@abs.com"));
        Assert.assertEquals(false, EmailValidator.validate("abs.com"));
        Assert.assertEquals(false, EmailValidator.validate("abs@com"));
        Assert.assertEquals(false, EmailValidator.validate("abs@gmail.c"));
        Assert.assertEquals(false, EmailValidator.validate("@gmail.c"));
        Assert.assertEquals(false, EmailValidator.validate("@"));
    }
}
