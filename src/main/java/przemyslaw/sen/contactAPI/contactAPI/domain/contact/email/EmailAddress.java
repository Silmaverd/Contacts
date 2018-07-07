package przemyslaw.sen.contactAPI.contactAPI.domain.contact.email;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmailAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "email", unique = true)
    private String emailAddress;

    private Long ownerId;

    public EmailAddress(String emailAddress, Long ownerId) throws InvalidEmailException {
        if (EmailValidator.validate(emailAddress)) {
            this.emailAddress = emailAddress;
            this.ownerId = ownerId;
        } else
            throw new InvalidEmailException(emailAddress + " is not a valid email address");
    }
}
