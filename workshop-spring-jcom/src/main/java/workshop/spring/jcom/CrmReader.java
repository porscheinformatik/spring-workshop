package workshop.spring.jcom;

import java.util.Arrays;
import java.util.List;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;

import at.porscheinformatik.common.utils.exception.TechnicalException;

import workshop.spring.data.entities.Contact;
import crm.Crm;
import crm.CustomerType;
import crm.ObjectFactory;
import cross.integration.cfram.distribution.AbstractRecordNumberDistributionReader;

public class CrmReader extends AbstractRecordNumberDistributionReader<Contact>
{
    private final Crm crm;
    private final ObjectFactory objectFactory = new ObjectFactory();
    public CrmReader(ResourceAwareItemReaderItemStream<Contact> itemReader, final Crm crm)
    {
        super(itemReader);
        this.crm = crm;
    }

    public String getInterface()
    {
        return "CRM";
    }

    @Override
    protected Contact readRecord(ResourceAwareItemReaderItemStream<Contact> reader)
    {
        try
        {
            return reader.read();
        }
        catch (UnexpectedInputException e)
        {
            throw new TechnicalException("Could not read Contact", e);
        }
        catch (ParseException e)
        {
            throw new TechnicalException("Could not read Contact", e);
        }
        catch (NonTransientResourceException e)
        {
            throw new TechnicalException("Could not read Contact", e);
        }
        catch (Exception e)
        {
            throw new TechnicalException("Could not read Contact", e);
        }
    }

    @Override
    protected boolean sendRecord(Contact record, StringBuffer errorBuffer)
    {
        
        CustomerType customerType = objectFactory.createCustomerType();
        customerType.setUuid(record.getId().intValue());
        crm.saveCustomer(customerType);
        return true;
    }

    @Override
    protected List<String> createProcessInfoKeyValues(Contact record)
    {
        return Arrays.asList(record.getId().toString(), record.getLastName());
    }

}
