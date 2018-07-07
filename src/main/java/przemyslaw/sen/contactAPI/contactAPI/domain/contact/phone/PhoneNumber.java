package przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @Column(name = "phoneNumber", unique = true)
    private String phoneNumber;

    private Long ownerId;

    public PhoneNumber(String phoneNumber, Long ownerId) throws InvalidPhoneNumberException {
        if (PhoneNumberValidator.validate(phoneNumber)) {
            this.phoneNumber = phoneNumber;
            this.ownerId = ownerId;
        } else
            throw new InvalidPhoneNumberException(phoneNumber + " is not a valid phone number");
    }
}
