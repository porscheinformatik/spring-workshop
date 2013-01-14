package workshop.spring.batch;

import org.apache.commons.lang.Validate;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.transform.FieldSet;

import workshop.spring.jpa.entities.Contact;
import workshop.spring.jpa.entities.Phone;


public class MultilineContactItemReader implements ItemReader<Contact>
{
    private FlatFileItemReader<FieldSet> delegate;
    private Contact contact = null;
    private Contact nextContact = null;
    
    public MultilineContactItemReader(final FlatFileItemReader<FieldSet> delegate)
    {
        this.delegate = delegate;
        ExecutionContext executionContext = new ExecutionContext();
        this.delegate.open(executionContext);
    }
    
    @Override
    public Contact read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException
    {
        contact = nextContact;
        nextContact = null;
        for (FieldSet fieldSet = null; (fieldSet = this.delegate.read()) != null;) {
            String prefix = fieldSet.readString("recordType");
            if (prefix.equals("C")) 
            {
                if (contact != null)
                {
                    nextContact = new Contact();
                    nextContact.setFirstName(fieldSet.readString("firstName"));
                    nextContact.setLastName(fieldSet.readString("lastName"));
                    return contact;
                }
                else
                {
                    contact = new Contact(); 
                    contact.setFirstName(fieldSet.readString("firstName"));
                    contact.setLastName(fieldSet.readString("lastName"));
                }
            }
            else if (prefix.equals("P")) 
            {
                Validate.notNull(contact, "No contact was found previously.");
                Phone phone = new Phone();
                phone.setNumber(fieldSet.readString("number"));
                phone.setContact(contact);
                contact.getPhones().add(phone);
            }
        }
        return contact;
    }

}
