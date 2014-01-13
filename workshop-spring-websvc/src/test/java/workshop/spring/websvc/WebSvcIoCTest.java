package workshop.spring.websvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import crm.CustomerType;
import crm.ObjectFactory;

@ContextConfiguration(locations="classpath:websvc.client.spring.xml")
public class WebSvcIoCTest  extends AbstractTestNGSpringContextTests
{
    @Autowired
    private Crm crm;
    
    @Test
    public void crmRequest()
    {
        CustomerType customerType = crm.getCustomer(1);
        System.out.println(customerType.getLastName());
    }
    @Test
    public void saveCustomer()
    {
        ObjectFactory factory = new ObjectFactory();
        CustomerType customerType = factory.createCustomerType();
        customerType.setUuid(1);
        crm.saveCustomer(customerType);
    }
}
