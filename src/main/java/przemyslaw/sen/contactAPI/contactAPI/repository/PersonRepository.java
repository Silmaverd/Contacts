package przemyslaw.sen.contactAPI.contactAPI.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import przemyslaw.sen.contactAPI.contactAPI.domain.person.Person;

import java.util.Date;
import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

    public List<Person> findByName(String name);

    public List<Person> findByBirthDateBetween(Date startDate, Date endDate);

    @Query("SELECT p FROM Person p " +
           "JOIN EmailAddress ea ON p.id = ea.ownerId " +
           "WHERE ea.emailAddress LIKE '%'||?1||'%'")
    public List<Person> findAllHavingEmailAddressMatching(String pattern);
}
