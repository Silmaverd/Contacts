package przemyslaw.sen.contactAPI.contactAPI.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.email.EmailAddress;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmailRepository extends CrudRepository<EmailAddress, String>{

    public List<EmailAddress> findAllByOwnerId(Long ownerId);

    public Optional<EmailAddress> findByEmailAddress(String emailAddress);

    @Modifying
    @Query("UPDATE EmailAddress ea SET ea.emailAddress = ?2 WHERE ea.emailAddress = ?1")
    public void updateEmailAddress(String oldAddress, String newAddress);
}
