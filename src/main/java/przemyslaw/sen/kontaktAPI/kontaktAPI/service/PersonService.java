package przemyslaw.sen.kontaktAPI.kontaktAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import przemyslaw.sen.kontaktAPI.kontaktAPI.domain.person.Gender;
import przemyslaw.sen.kontaktAPI.kontaktAPI.domain.person.Person;
import przemyslaw.sen.kontaktAPI.kontaktAPI.domain.person.PersonBuilder;
import przemyslaw.sen.kontaktAPI.kontaktAPI.domain.person.pesel.InvalidPeselException;
import przemyslaw.sen.kontaktAPI.kontaktAPI.repository.PersonRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

    public void addPerson(String name, String birthDate, String gender, String peselNumber)
            throws ParseException, InvalidPeselException {
        PersonBuilder personBuilder = new PersonBuilder();
        Person person = personBuilder
                .aPerson()
                .withName(name)
                .withGender(Gender.valueOf(gender))
                .withBirthDate(dateFormatter.parse(birthDate))
                .withPesel(peselNumber)
                .build();

        personRepository.save(person);
    }

    public List<Person> getPerson(String name) {
        return personRepository.findByName(name);
    }

    public void deletePerson(Long id) {
        Optional<Person> person = personRepository.findById(id);
        if (person.isPresent())
            personRepository.delete(person.get());
        else
            throw new IllegalArgumentException("Person with id " + id + " does not exist");
    }
}
