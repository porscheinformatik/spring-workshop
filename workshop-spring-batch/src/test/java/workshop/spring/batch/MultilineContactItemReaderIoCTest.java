package workshop.spring.batch;

import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;


@ContextConfiguration(locations="classpath:META-INF/worckshop.spring.batch.contact.xml")
public class MultilineContactItemReaderIoCTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private MultilineContactItemReader target;
    
    @Test
    public void read() throws UnexpectedInputException, ParseException, NonTransientResourceException, Exception
    {
        Assert.assertNotNull(target.read());
    }
}
