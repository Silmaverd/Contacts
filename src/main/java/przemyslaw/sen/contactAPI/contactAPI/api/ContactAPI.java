package przemyslaw.sen.contactAPI.contactAPI.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import przemyslaw.sen.contactAPI.contactAPI.service.ContactService;
import przemyslaw.sen.contactAPI.contactAPI.service.PersonService;
import przemyslaw.sen.contactAPI.contactAPI.view.EmailView;
import przemyslaw.sen.contactAPI.contactAPI.view.PhoneNumberView;
import przemyslaw.sen.contactAPI.contactAPI.view.Response;

import java.util.Optional;
import java.util.stream.Collectors;

@Api
@RestController
@RequestMapping("/api/contact")
public class ContactAPI {

    @Autowired
    private ContactService contactService;

    @RequestMapping(path = "/contact/addEmailAddressForPerson", method = {RequestMethod.PUT})
    @ApiOperation(value = "Adds email address for person with specified id", response = Response.class)
    public Response addEmail(
            @RequestParam(value = "PersonId") Long personId,
            @RequestParam(value = "Email") String emailAddress) {
        try {
            contactService.addEmailForPerson(emailAddress, personId);
            return new Response(true, Optional.empty());
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }

    @RequestMapping(path = "/contact/deleteEmail", method = {RequestMethod.DELETE})
    @ApiOperation(value = "Deletes an email address", response = Response.class)
    public Response deleteEmail(
            @RequestParam(value = "Email") String emailAddress) {
        try {
            contactService.deleteEmail(emailAddress);
            return new Response(true, Optional.empty());
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }

    @RequestMapping(path = "/contact/updateEmailAddress", method = {RequestMethod.PATCH})
    @ApiOperation(value = "Updates specified email address with a new one", response = Response.class)
    public Response updateEmail(
            @RequestParam(value = "OldAddress") String oldAddress,
            @RequestParam(value = "NewAddress") String newAddress) {
        try {
            contactService.updateEmail(oldAddress, newAddress);
            return new Response(true, Optional.empty());
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }

    @RequestMapping(path = "/contact/getEmailAddressForPerson", method = {RequestMethod.GET})
    @ApiOperation(value = "Fetches email addresses for specified person", response = Response.class)
    public Response getEmail(
            @RequestParam(value = "PersonId") Long personId) {
        try {
            return new Response(
                    true,
                    contactService.getEmailsForPerson(personId)
                            .stream()
                            .map(EmailView::from)
                            .collect(Collectors.toList()));
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }

    @RequestMapping(path = "/contact/addPhoneNumberForPerson", method = {RequestMethod.PUT})
    @ApiOperation(value = "Adds phone number for person with specified id", response = Response.class)
    public Response addPhoneNumber(
            @RequestParam(value = "PersonId") Long personId,
            @RequestParam(value = "PhoneNumber") String phoneNumber) {
        try {
            contactService.addPhoneNrForPerson(phoneNumber, personId);
            return new Response(true, Optional.empty());
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }

    @RequestMapping(path = "/contact/deletePhoneNumber", method = {RequestMethod.DELETE})
    @ApiOperation(value = "Deletes a phone number", response = Response.class)
    public Response deletePhoneNumber(
            @RequestParam(value = "PhoneNumber") String phoneNumber) {
        try {
            contactService.deletePhoneNumber(phoneNumber);
            return new Response(true, Optional.empty());
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }

    @RequestMapping(path = "/contact/updatePhoneNumber", method = {RequestMethod.PATCH})
    @ApiOperation(value = "Updates specified phone number with a new one", response = Response.class)
    public Response updatePhoneNumber(
            @RequestParam(value = "OldNumber") String oldNumber,
            @RequestParam(value = "NewNumber") String newNumber) {
        try {
            contactService.updatePhoneNumber(oldNumber, newNumber);
            return new Response(true, Optional.empty());
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }

    @RequestMapping(path = "/contact/getPhoneNumbersForPerson", method = {RequestMethod.GET})
    @ApiOperation(value = "Fetches phone numbers for specified person", response = Response.class)
    public Response getPhoneNumber(
            @RequestParam(value = "PersonId") Long personId) {
        try {
            return new Response(
                    true,
                    contactService.getPhoneNumbersForPerson(personId)
                            .stream()
                            .map(PhoneNumberView::from)
                            .collect(Collectors.toList()));
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }
}
