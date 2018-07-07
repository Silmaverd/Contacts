package przemyslaw.sen.contactAPI.contactAPI.source.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.email.EmailAddress;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone.PhoneNumber;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.Person;
import przemyslaw.sen.contactAPI.contactAPI.service.ContactService;
import przemyslaw.sen.contactAPI.contactAPI.service.PersonService;
import przemyslaw.sen.contactAPI.contactAPI.source.DataSource;
import przemyslaw.sen.contactAPI.contactAPI.source.xml.structures.AllDomainData;
import przemyslaw.sen.contactAPI.contactAPI.source.xml.structures.XMLEmail;
import przemyslaw.sen.contactAPI.contactAPI.source.xml.structures.XMLPerson;
import przemyslaw.sen.contactAPI.contactAPI.source.xml.structures.XMLPhoneNr;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.List;

@Component
public class XMLDataSource implements DataSource {

    @Autowired
    private ContactService contactService;

    @Autowired
    private PersonService personService;

    @Override
    public void read(String filePath) {
        AllDomainData allDomainData = null;
        try {
            allDomainData = readAllDomainData(filePath);
            persistPersons(allDomainData.getPersons());
            persistEmails(allDomainData.getEmails());
            persistPhoneNumbers(allDomainData.getPhones());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private AllDomainData readAllDomainData(String path) throws JAXBException {
        File file = new File(path);
        JAXBContext jaxbContext = JAXBContext.newInstance(AllDomainData.class);

        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        return (AllDomainData) jaxbUnmarshaller.unmarshal(file);
    }

    //TODO: should not fail for all data on single error
    private void persistPersons(List<XMLPerson> xmlPersonList) {
        xmlPersonList.forEach(xmlPerson -> {
            Person person = XMLToEntityConverter.XMLPersonToPerson(xmlPerson);
            personService.addPerson(person);
        });
    }

    private void persistEmails(List<XMLEmail> xmlEmails) {
        xmlEmails.forEach(xmlEmail -> {
            EmailAddress emailAddress = XMLToEntityConverter.XMLEmailToEmailAddress(xmlEmail);
            contactService.addEmail(emailAddress);
        });
    }

    private void persistPhoneNumbers(List<XMLPhoneNr> xmlPhoneNrs) {
        xmlPhoneNrs.forEach(xmlPhoneNr -> {
            PhoneNumber phoneNumber = XMLToEntityConverter.XMLPhoneNumberToPhoneNumber(xmlPhoneNr);
            contactService.addPhoneNumber(phoneNumber);
        });
    }
}
