package workshop.spring.config.stereotype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import workshop.spring.config.StockFacade;

@Component("stockFacade")
public class ComponentStockFacade implements StockFacade
{
    private static final Logger LOGGER = LoggerFactory.getLogger(ComponentStockFacade.class);
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
