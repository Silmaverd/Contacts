package przemyslaw.sen.contactAPI.contactAPI.view;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.email.EmailAddress;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone.PhoneNumber;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.Person;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PersonWithContactsView implements View{
    private PersonView personView;
    private List<EmailView> emailAddresses;
    private List<PhoneNumberView> phoneNumbers;

    public static PersonWithContactsView from(Person person, List<EmailAddress> emails, List<PhoneNumber> phoneNumbers) {
        return new PersonWithContactsView(
                PersonView.from(person),
                emails.stream().map(EmailView::from).collect(Collectors.toList()),
                phoneNumbers.stream().map(PhoneNumberView::from).collect(Collectors.toList())
        );
    }
}
