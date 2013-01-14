package workshop.spring.aop;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EntryExitLogging
public class OrderManagerImpl implements OrderManager
{
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderManagerImpl.class);
    @Override
    public void order(List<String> items)
    {
        LOGGER.info("Process order for items {}", items.toString());
    }
}
