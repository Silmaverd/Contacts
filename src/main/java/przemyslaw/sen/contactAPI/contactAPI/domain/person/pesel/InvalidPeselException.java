package przemyslaw.sen.contactAPI.contactAPI.domain.person.pesel;

public class InvalidPeselException extends Exception {
    public InvalidPeselException(String s) {
        super(s);
    }
}
