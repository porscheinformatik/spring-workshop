package workshop.spring.websvc;

import java.util.Map;

import javax.xml.ws.BindingProvider;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import crmclient.Crm;
import crmclient.CrmService;
import crmclient.CustomerType;
import crmclient.ObjectFactory;

public class WebSvcTest
{
    private Crm target;
    @BeforeMethod
    public void setUp()
    {
        CrmService crmService = new CrmService();
        target = crmService.getPort(Crm.class);
        Map<String, Object> requestContext = ((BindingProvider) target).getRequestContext();
        requestContext.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://localhost:8081/crm-ws/CrmRequest");       
    }
    
    @Test
    public void getCustomer()
    {
        CustomerType customerType = target.getCustomer(1);
        System.out.println(customerType.getLastName());
    }
    
    @Test
    public void saveCustomer()
    {
        ObjectFactory factory = new ObjectFactory();
        CustomerType customerType = factory.createCustomerType();
        customerType.setUuid(1);
        target.saveCustomer(customerType);
    }
}
