package przemyslaw.sen.contactAPI.contactAPI.source.xml.structures;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllDomainData", propOrder = {
        "persons", "emails", "phones"
})
@XmlRootElement(name = "AllDomainData")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AllDomainData
        implements Serializable {

    private final static long serialVersionUID = 12343L;
    @XmlElement(name = "Person", required = true)
    protected List<XMLPerson> persons;

    @XmlElement(name = "Email", required = true)
    protected List<XMLEmail> emails;

    @XmlElement(name = "Phone", required = true)
    protected List<XMLPhoneNr> phones;

}
