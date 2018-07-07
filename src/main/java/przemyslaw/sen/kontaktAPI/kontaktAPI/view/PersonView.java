package przemyslaw.sen.kontaktAPI.kontaktAPI.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import przemyslaw.sen.kontaktAPI.kontaktAPI.domain.person.Person;

import java.util.Date;

@ToString
@Getter
@AllArgsConstructor
public class PersonView implements View {
    private Long id;
    private String personName;
    private Date dateOfBirth;
    private String gender;
    private String peselNumber;

    public static PersonView from(Person person) {
        return new PersonView(
                person.getId(),
                person.getName(),
                person.getBirthDate(),
                person.getGender().toString(),
                person.getPesel()
        );
    }
}
