package workshop.spring.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Phone data for {@link Contact}.
 * @author Anders Malmborg
 *
 */
@Entity
public class Phone
{
    @Id
    @GeneratedValue
    private Long id;
    private String number;
    @ManyToOne
    private Contact contact;
    

    public String getNumber()
    {
        return number;
    }

    public void setNumber(String number)
    {
        this.number = number;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Contact getContact()
    {
        return contact;
    }

    public void setContact(Contact contact)
    {
        this.contact = contact;
    }
}
