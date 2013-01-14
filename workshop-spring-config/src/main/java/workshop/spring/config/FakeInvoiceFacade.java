package workshop.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FakeInvoiceFacade implements InvoiceFacade
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FakeInvoiceFacade.class);

    public void createInvoide(String order)
    {
        LOGGER.info("Invoice for order {} created", order);
    }

}
