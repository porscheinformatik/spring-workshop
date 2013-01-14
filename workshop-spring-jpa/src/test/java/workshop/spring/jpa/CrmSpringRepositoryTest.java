package workshop.spring.jpa;

import static org.testng.Assert.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import workshop.spring.jpa.entities.Contact;
import workshop.spring.jpa.entities.Phone;

@ContextConfiguration(locations="classpath:META-INF/jpa-spring.xml")
public class CrmSpringRepositoryTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private CrmRepository target;
    
    @Test
    public void load()
    {
        Contact contact = new Contact();
        contact.setLastName("Test");
        Phone phone = new Phone();
        phone.setContact(contact);
        phone.setNumber("123456");
        contact.getPhones().add(phone);
        phone = new Phone();
        phone.setContact(contact);
        phone.setNumber("987654");
        contact.getPhones().add(phone);
            
        contact = target.save(contact);
        
        contact = target.load(contact.getId());
        assertEquals(contact.getPhones().size(), 2);

    }
    @Test(dependsOnMethods="load")
    public void findContactByLastname()
    {
        List<Contact> contacts = target.findContactByLastname("Test");
        assertTrue(contacts.size() > 0);
    }

}
