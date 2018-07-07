package przemyslaw.sen.contactAPI.contactAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.email.InvalidEmailException;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone.InvalidPhoneNumberException;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone.PhoneNumber;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone.PhoneNumberValidator;
import przemyslaw.sen.contactAPI.contactAPI.repository.PersonRepository;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.email.EmailAddress;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.email.EmailValidator;
import przemyslaw.sen.contactAPI.contactAPI.repository.EmailRepository;
import przemyslaw.sen.contactAPI.contactAPI.repository.PhoneNumberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    public ContactService(PersonRepository personRepository, EmailRepository emailRepository, PhoneNumberRepository phoneNumberRepository) {
        this.personRepository = personRepository;
        this.emailRepository = emailRepository;
        this.phoneNumberRepository = phoneNumberRepository;
    }

    private PersonRepository personRepository;
    private EmailRepository emailRepository;
    private PhoneNumberRepository phoneNumberRepository;

    public void addEmailForPerson(String email, Long personId) throws InvalidEmailException {
        if (personRepository.findById(personId).isPresent())
            emailRepository.save(new EmailAddress(email, personId));
    }

    public void addPhoneNrForPerson(String phoneNumber, Long personId) throws InvalidPhoneNumberException {
        if (personRepository.findById(personId).isPresent())
            phoneNumberRepository.save(new PhoneNumber(phoneNumber, personId));
    }

    //TODO: ensure only correct data is beeing saved
    public void addEmail(EmailAddress emailAddress) {
        emailRepository.save(emailAddress);
    }

    //TODO: ensure only correct data is beeing saved
    public void addPhoneNumber(PhoneNumber phoneNumber) {
        phoneNumberRepository.save(phoneNumber);
    }

    public List<EmailAddress> getEmailsForPerson(Long personId) {
        return emailRepository.findAllByOwnerId(personId);
    }

    public List<PhoneNumber> getPhoneNumbersForPerson(Long personId) {
        return phoneNumberRepository.findAllByOwnerId(personId);
    }

    public void deleteEmail(String emailAdderss) {
        Optional<EmailAddress> maybeEmailAddress = emailRepository.findByEmailAddress(emailAdderss);
        if (maybeEmailAddress.isPresent())
            emailRepository.delete(maybeEmailAddress.get());
        else
            throw new IllegalArgumentException("Email address " + emailAdderss + " does not exist");
    }

    public void deletePhoneNumber(String phoneNr) {
        Optional<PhoneNumber> maybePhoneNumber = phoneNumberRepository.findByPhoneNumber(phoneNr);
        if (maybePhoneNumber.isPresent())
            phoneNumberRepository.delete(maybePhoneNumber.get());
        else
            throw new IllegalArgumentException("Phone number " + phoneNr + " does not exist");
    }

    @Transactional
    public void updateEmail(String oldEmail, String newEmail) {
        Optional<EmailAddress> maybeEmailAddress = emailRepository.findByEmailAddress(oldEmail);

        if (!maybeEmailAddress.isPresent())
            throw new IllegalArgumentException("Email address " + oldEmail + " does not exist");
        if (!EmailValidator.validate(newEmail))
            throw new IllegalArgumentException(newEmail + " is not a valid email address");

        emailRepository.updateEmailAddress(oldEmail, newEmail);
    }

    @Transactional
    public void updatePhoneNumber(String oldPhoneNumber, String newPhoneNumber) {
        Optional<PhoneNumber> maybePhoneNumber = phoneNumberRepository.findByPhoneNumber(newPhoneNumber);

        if (!maybePhoneNumber.isPresent())
            throw new IllegalArgumentException("Phone number" + oldPhoneNumber + " does not exist");
        if (!PhoneNumberValidator.validate(newPhoneNumber))
            throw new IllegalArgumentException(newPhoneNumber + " is not a valid phone number");

        phoneNumberRepository.updatePhoneNumber(oldPhoneNumber, newPhoneNumber);
    }
}
