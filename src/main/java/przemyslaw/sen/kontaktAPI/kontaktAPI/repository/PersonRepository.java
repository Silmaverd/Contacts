package przemyslaw.sen.kontaktAPI.kontaktAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import przemyslaw.sen.kontaktAPI.kontaktAPI.domain.person.Person;

import java.util.List;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{

    public List<Person> findByName(String name);
}
