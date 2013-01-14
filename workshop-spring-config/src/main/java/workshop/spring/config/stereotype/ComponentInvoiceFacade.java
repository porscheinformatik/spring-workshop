package workshop.spring.config.stereotype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import workshop.spring.config.InvoiceFacade;

@Component
public class ComponentInvoiceFacade implements InvoiceFacade
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentInvoiceFacade.class);

    public void createInvoide(String order)
    {
        LOGGER.info("Invoice for order {} created", order);
    }

}
