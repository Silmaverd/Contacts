package przemyslaw.sen.contactAPI.contactAPI.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone.PhoneNumber;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PhoneNumberView implements View {
    private String phoneNumber;

    public static PhoneNumberView from(PhoneNumber phoneNumber) {
        return new PhoneNumberView(phoneNumber.getPhoneNumber());
    }
}
