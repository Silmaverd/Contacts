package przemyslaw.sen.contactAPI.contactAPI.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import przemyslaw.sen.contactAPI.contactAPI.domain.contact.phone.PhoneNumber;

import java.util.List;
import java.util.Optional;

@Repository
public interface PhoneNumberRepository extends CrudRepository<PhoneNumber, String>{

    public List<PhoneNumber> findAllByOwnerId(Long ownerId);

    public Optional<PhoneNumber> findByPhoneNumber(String phoneNumebr);

    @Modifying
    @Query("UPDATE PhoneNumber pn SET phoneNumber = ?2 WHERE phoneNumber = ?1")
    public void updatePhoneNumber(String oldNumber, String newNumber);
}
