package workshop.spring.jcom;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import workshop.spring.data.entities.Contact;

public class ContactFieldSetMapper implements FieldSetMapper<Contact>
{

    @Override
    public Contact mapFieldSet(FieldSet fieldSet) throws BindException
    {
        Contact contact = new Contact();
        contact.setId(fieldSet.readLong("id"));
        contact.setLastName(fieldSet.readString("lastName"));
        contact.setFirstName(fieldSet.readString("firstName"));
        return contact;
    }

}
