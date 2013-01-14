package workshop.spring.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import at.porscheinformatik.common.utils.exception.TechnicalException;

import workshop.spring.jpa.entities.Contact;

/**
 * Spring implementation of {@link CrmRepository}.
 * @author Anders Malmborg
 *
 */
@Transactional
public class CrmSpringRepository implements CrmRepository
{
    @PersistenceContext
    private EntityManager entityManager;

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
            throw new TechnicalException("No Contact with primary key "+id.toString());
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
