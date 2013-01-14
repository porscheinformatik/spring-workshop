package workshop.spring.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Address
{
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    @ManyToOne
    private Contact contact;
    public Long getId()
    {
        return id;
    }
    public void setId(Long id)
    {
        this.id = id;
    }
    public String getStreet()
    {
        return street;
    }
    public void setStreet(String street)
    {
        this.street = street;
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
