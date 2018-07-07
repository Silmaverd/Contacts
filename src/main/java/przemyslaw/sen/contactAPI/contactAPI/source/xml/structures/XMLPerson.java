package przemyslaw.sen.contactAPI.contactAPI.source.xml.structures;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class XMLPerson {
    public Long id;
    public String name;
    public Date birthDate;
    public String gender;
    public String pesel;
}
