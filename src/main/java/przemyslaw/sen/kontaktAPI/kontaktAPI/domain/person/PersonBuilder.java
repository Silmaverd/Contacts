package przemyslaw.sen.kontaktAPI.kontaktAPI.domain.person;

import lombok.NoArgsConstructor;
import przemyslaw.sen.kontaktAPI.kontaktAPI.domain.person.pesel.InvalidPeselException;
import przemyslaw.sen.kontaktAPI.kontaktAPI.domain.person.pesel.PeselValidator;

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

    public PersonBuilder withBirthDate(Date date) {
        this.birthDate = date;
        return this;
    }

    public PersonBuilder withPesel(String pesel) throws InvalidPeselException {
        if (!PeselValidator.isValid(pesel))
            throw new InvalidPeselException(pesel + " is not a valid pesel number");
        else
            this.peselNumber = pesel;
        return this;
    }

    public Person build() {
        return new Person(this.name, this.gender, this.peselNumber, this.birthDate);
    }
}
