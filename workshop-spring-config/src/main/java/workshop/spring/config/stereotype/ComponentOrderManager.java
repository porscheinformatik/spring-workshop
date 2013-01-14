package workshop.spring.config.stereotype;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import workshop.spring.config.InvoiceFacade;
import workshop.spring.config.OrderManager;
import workshop.spring.config.StockFacade;

@Component
public class ComponentOrderManager implements OrderManager
{
    private static final String ITEM = "Spring Workshop";
    private static final String ORDER = "Workshop Package";
    
    private final StockFacade stockFacade;
    private final InvoiceFacade invoiceFacade;
    
    @Autowired
    public ComponentOrderManager(@Qualifier("stockFacade")final StockFacade stockFacade, 
                                 final InvoiceFacade invoiceFacade)
    {
        this.stockFacade = stockFacade;
        this.invoiceFacade = invoiceFacade;
    }
    public void processOrder()
    {
        if (!stockFacade.itemOnStock(ITEM))
        {
            stockFacade.orderItem(ITEM);
        }
        invoiceFacade.createInvoide(ORDER);
    }

}
