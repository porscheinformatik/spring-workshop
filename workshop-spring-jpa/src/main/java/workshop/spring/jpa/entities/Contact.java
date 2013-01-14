package workshop.spring.jpa.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Holds the data of a contact, e.g. a customer.
 * @author Anders Malmborg
 *
 */
@Entity
public class Contact
{
    @Id
    @GeneratedValue
    private Long id;
    @Column(length=50, nullable=false)
    private String lastName;
    private String firstName;
    @OneToMany(mappedBy="contact", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
    private List<Phone> phones = new ArrayList<Phone>();
    
    public String getLastName()
    {
        return lastName;
    }
    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }
    public String getFirstName()
    {
        return firstName;
    }
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }
    public List<Phone> getPhones()
    {
        return phones;
    }
    public void setPhones(List<Phone> phones)
    {
        this.phones = phones;
    }
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
}
