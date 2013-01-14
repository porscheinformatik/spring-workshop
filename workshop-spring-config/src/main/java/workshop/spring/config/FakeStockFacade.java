package workshop.spring.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FakeStockFacade implements StockFacade
{
    private static final Logger LOGGER = LoggerFactory.getLogger(FakeStockFacade.class);
    public boolean itemOnStock(String item)
    {
        LOGGER.info("Item {} is on stock", item);
        return true;
    }

    public void orderItem(String item)
    {
        LOGGER.info("Item {} ordered", item);
    }

}
