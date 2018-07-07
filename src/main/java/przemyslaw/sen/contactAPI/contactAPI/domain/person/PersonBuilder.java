package przemyslaw.sen.contactAPI.contactAPI.domain.person;

import lombok.NoArgsConstructor;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.date.BirthDateValidator;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.date.InvalidDateException;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.pesel.InvalidPeselException;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.pesel.PeselValidator;

import java.text.ParseException;
import java.util.Date;

@NoArgsConstructor
public final class PersonBuilder {

    private String name = null;
    private String peselNumber = null;
    private Date birthDate = null;
    private Gender gender = Gender.NO_INFO;

    public PersonBuilder aPerson(){
        return new PersonBuilder();
    }

    public PersonBuilder withName(String name){
        this.name = name;
        return this;
    }

    public PersonBuilder withGender(Gender gender){
        this.gender = gender;
        return this;
    }

    public PersonBuilder withBirthDate(Date date) throws ParseException, InvalidDateException {
        if (BirthDateValidator.validate(date))
            this.birthDate = date;
        else
            throw new InvalidDateException(date + " is not a valid date");
        return this;
    }

    public PersonBuilder withPesel(String pesel) throws InvalidPeselException {
        if (PeselValidator.validate(pesel))
            this.peselNumber = pesel;
        else
            throw new InvalidPeselException(pesel + " is not a valid pesel number");
        return this;
    }

    public Person build() {
        return new Person(this.name, this.gender, this.peselNumber, this.birthDate);
    }
}
