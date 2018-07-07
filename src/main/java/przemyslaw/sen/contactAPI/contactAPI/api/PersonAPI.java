package przemyslaw.sen.contactAPI.contactAPI.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.Person;
import przemyslaw.sen.contactAPI.contactAPI.service.PersonService;
import przemyslaw.sen.contactAPI.contactAPI.view.PersonView;
import przemyslaw.sen.contactAPI.contactAPI.view.Response;

import java.util.Optional;
import java.util.stream.Collectors;

@Api
@RestController
@RequestMapping("/api/person")
public class PersonAPI {

    @Autowired
    private PersonService personService;

    @RequestMapping(path = "/person/addPerson", method = {RequestMethod.PUT})
    @ApiOperation(value = "Add a person", response = Response.class)
    public Response addPerson(
            @RequestParam(value = "Name")String name,
            @RequestParam(value = "DateOfBirth(dd/mm/yyyy)")String birthDate,
            @RequestParam(value = "Gender")String gender,
            @RequestParam(value = "PeselNumber")String peselNumber
    ) {
        try {
            personService.addPerson(name, birthDate, gender, peselNumber);
            return new Response(true, Optional.empty());
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }

    @RequestMapping(path = "/person/getPerson", method = {RequestMethod.GET})
    @ApiOperation(value = "Fetch a person with name", response = Person.class)
    public Response getPerson(@RequestParam String name) {
        try {
            return new Response<PersonView>(
                    true,
                    personService.getPerson(name)
                            .stream()
                            .map(PersonView::from)
                            .collect(Collectors.toList())
            );
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }

    @RequestMapping(path = "/person/removePerson", method = {RequestMethod.DELETE})
    @ApiOperation(value = "Remove person with id", response = Person.class)
    public Response removePerson(@RequestParam Long id) {
        try {
            personService.deletePerson(id);
            return new Response(true, Optional.empty());
        } catch (Exception e) {
            return new Response(false, Optional.of(e.toString()));
        }
    }
}
