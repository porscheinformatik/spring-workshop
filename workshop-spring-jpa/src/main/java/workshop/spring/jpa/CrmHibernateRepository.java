package workshop.spring.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import workshop.spring.jpa.entities.Contact;

/**
 * Hibernate implementation of {@link CrmRepository}.
 * @author Anders Malmborg
 *
 */
public class CrmHibernateRepository implements CrmRepository
{
    private final EntityManager entityManager;

    /**
     * @param entityManager {@link EntityManager}
     */
    public CrmHibernateRepository(final EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    
    @Override
    public Contact save(final Contact contact)
    {
        return entityManager.merge(contact);
    }

    @Override
    public Contact load(final Long id)
    {
        Contact contact = entityManager.find(Contact.class, id);
        if (contact == null)
        {
            throw new RuntimeException("No Contact with primary key "+id.toString());
        }
        return contact;
    }

    @Override
    public List<Contact> findContactByLastname(final String lastName)
    {
        TypedQuery<Contact> query = entityManager.createNamedQuery("findByLastName", Contact.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }

}
