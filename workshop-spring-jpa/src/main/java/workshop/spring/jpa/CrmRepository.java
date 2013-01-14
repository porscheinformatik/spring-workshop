package workshop.spring.jpa;

import java.util.List;

import workshop.spring.jpa.entities.Contact;


/**
 * Facade for Customer Relationship Management Module.
 * @author Anders Malmborg
 *
 */
public interface CrmRepository
{
    /**
     * Inserts/updates a contact into the database.
     * @param contact {@link Contact}
     * @return {@link Contact}
     */
    Contact save(Contact contact);

    /**
     * Loads a Context from the database.
     * Will throw a TechnicalException if the entity could not be found.
     * @param id primary key
     * @return {@link Contact}
     */
    Contact load(Long id);
    
    /**
     * Finds all Contacts matching last name.
     * @param lastName last name
     * @return list of {@link Contact}'s
     */
    List<Contact> findContactByLastname(String lastName);
}
