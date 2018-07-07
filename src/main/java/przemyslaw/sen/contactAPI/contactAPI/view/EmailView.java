package przemyslaw.sen.contactAPI.contactAPI.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.email.EmailAddress;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EmailView implements View{
    private String emailAddress;

    public static EmailView from(EmailAddress emailAddress) {
        return new EmailView(emailAddress.getEmailAddress());
    }
}
