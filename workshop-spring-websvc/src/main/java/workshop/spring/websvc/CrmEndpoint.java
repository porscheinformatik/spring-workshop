package workshop.spring.websvc;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import crm.AddressType;
import crm.CustomerType;
import crm.ObjectFactory;

@Endpoint
public class CrmEndpoint
{
    private static final Logger LOGGER = LoggerFactory.getLogger(CrmEndpoint.class);
    private static final String NAMESPACE_URI = "http://crm";
    private final ObjectFactory fct = new ObjectFactory();
    
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetCustomerRequest")
    @ResponsePayload
    public JAXBElement<CustomerType> getCustomerRequest(@RequestPayload JAXBElement<Integer> request)
    {
        CustomerType customerType = fct.createCustomerType();
        customerType.setLastName("last name");
        customerType.setUuid(1);
        AddressType addressType = fct.createAddressType();
        addressType.setDefault(true);
        addressType.setStreet("straße");
        addressType.setZip("123 45");
        addressType.setCity("city");
        customerType.getAddress().add(addressType);
        return fct.createGetCustomerResponse(customerType );
    }
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SaveCustomerRequest")
    public void saveCustomerRequest(@RequestPayload JAXBElement<CustomerType> request)
    {
        LOGGER.info("Save Customer with id {}", request.getValue().getUuid());
    }

}
