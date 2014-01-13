package workshop.spring.data;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import workshop.spring.data.entities.Contact;
import workshop.spring.data.entities.Phone;

@ContextConfiguration(locations="classpath:META-INF/spring-data-spring.xml")
public class ContactRepositoryTest extends AbstractTestNGSpringContextTests 
{
     @Autowired
     private ContactRepository target;
     
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
         
         contact = target.findOne(contact.getId());
         assertEquals(contact.getPhones().size(), 2);
         
         contact.getPhones().remove(0);
         contact = target.save(contact);
         
         contact = target.findOne(contact.getId());
         assertEquals(contact.getPhones().size(), 1);
         contact.getPhones().get(0).setNumber("9");
         contact = target.save(contact);
         
         contact = target.findOne(contact.getId());
         assertEquals(contact.getPhones().get(0).getNumber(), "9");
         
     }
     @Test(dependsOnMethods="load")
     public void findContactByLastname()
     {
         List<Contact> contacts = target.findContactByLastName("Test");
         assertTrue(contacts.size() > 0);
         assertEquals(contacts.get(0).getPhones().get(0).getNumber(), "9");
     }
     @Test(dependsOnMethods="load")
     public void findContactByPhone()
     {
         List<Contact> contacts = target.findContactByPhonesNumber("9");
         assertTrue(contacts.size() > 0);
     }
     
}
