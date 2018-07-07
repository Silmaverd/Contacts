package przemyslaw.sen.kontaktAPI.kontaktAPI.domain.person;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String pesel;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    public Person(String name, Gender gender, String pesel, Date birthDate) {
        this.name = name;
        this.gender = gender;
        this.pesel = pesel;
        this.birthDate = birthDate;
    }
}
