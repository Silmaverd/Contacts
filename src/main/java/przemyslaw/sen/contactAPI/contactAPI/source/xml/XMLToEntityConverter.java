package przemyslaw.sen.contactAPI.contactAPI.source.xml;

import przemyslaw.sen.contactAPI.contactAPI.domain.contact.email.EmailAddress;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone.PhoneNumber;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.Gender;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.Person;
import przemyslaw.sen.contactAPI.contactAPI.source.xml.structures.XMLEmail;
import przemyslaw.sen.contactAPI.contactAPI.source.xml.structures.XMLPerson;
import przemyslaw.sen.contactAPI.contactAPI.source.xml.structures.XMLPhoneNr;

public class XMLToEntityConverter {

    public static Person XMLPersonToPerson(XMLPerson xmlPerson) {
        return new Person(xmlPerson.id, xmlPerson.name, Gender.valueOf(xmlPerson.gender), xmlPerson.pesel, xmlPerson.birthDate);
    }

    public static EmailAddress XMLEmailToEmailAddress(XMLEmail xmlEmail) {
        return new EmailAddress(xmlEmail.id, xmlEmail.emailAddress, xmlEmail.ownerId);
    }

    public static PhoneNumber XMLPhoneNumberToPhoneNumber(XMLPhoneNr xmlPhoneNr) {
        return new PhoneNumber(xmlPhoneNr.id, xmlPhoneNr.phoneNumber, xmlPhoneNr.ownerId);
    }
}
