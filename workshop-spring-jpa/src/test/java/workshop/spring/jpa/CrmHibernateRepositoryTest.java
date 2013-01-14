package workshop.spring.jpa;

import static org.testng.Assert.*;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import workshop.spring.jpa.entities.Contact;
import workshop.spring.jpa.entities.Phone;

public class CrmHibernateRepositoryTest
{
    private CrmHibernateRepository target;
    private EntityManagerFactory emf;
    private EntityManager em;
    
    @BeforeClass
    public void setUp()
    {
        emf = Persistence.createEntityManagerFactory("workshop-spring");
        em = emf.createEntityManager();
        target = new CrmHibernateRepository(em);
    }
    
    @Test
    public void load()
    {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
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
        tx.commit();

    }
    @Test(dependsOnMethods="load")
    public void findContactByLastname()
    {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Contact> contacts = target.findContactByLastname("Test");
        assertTrue(contacts.size() > 0);
        tx.commit();
    }
}
