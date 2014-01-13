package workshop.spring.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import workshop.spring.data.entities.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long>
{
    List<Contact> findContactByLastName(String lastName);
    List<Contact> findContactByPhonesNumber(String number);
}
