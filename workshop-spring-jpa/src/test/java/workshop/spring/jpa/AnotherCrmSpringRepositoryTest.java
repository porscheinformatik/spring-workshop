package workshop.spring.jpa;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;

import workshop.spring.jpa.entities.Contact;
import workshop.spring.jpa.entities.Phone;

//@ContextConfiguration(locations="classpath:test.jpa-spring.xml")
@ContextConfiguration(locations="classpath:META-INF/jpa-spring.xml")
@Test(groups="single")
public class AnotherCrmSpringRepositoryTest extends AbstractTransactionalTestNGSpringContextTests
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
