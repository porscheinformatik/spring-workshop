package workshop.spring.config;


public class OrderManagerConstructorInjection implements OrderManager
{
    private static final String ITEM = "Spring Workshop";
    private static final String ORDER = "Workshop Package";
    
    private final StockFacade stockFacade;
    private final InvoiceFacade invoiceFacade;
    
    public OrderManagerConstructorInjection(final StockFacade stockFacade, final InvoiceFacade invoiceFacade)
    {
        this.stockFacade = stockFacade;
        this.invoiceFacade = invoiceFacade;
    }
    public void processOrder()
    {
        if (!stockFacade.itemOnStock(ITEM))
        {
            stockFacade.orderItem(ITEM);
            invoiceFacade.createInvoide(ORDER);
        }
    }
}
