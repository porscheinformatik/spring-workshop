package workshop.spring.config;

public class OrderManagerSetterInjection implements OrderManager
{
    private static final String ITEM = "Spring Workshop";
    private static final String ORDER = "Workshop Package";


    private StockFacade stockFacade;
    private InvoiceFacade invoiceFacade;

    public void processOrder()
    {
        if (!stockFacade.itemOnStock(ITEM))
        {
            stockFacade.orderItem(ITEM);
        }
        invoiceFacade.createInvoide(ORDER);
    }

    public void setStockFacade(final StockFacade stockFacade)
    {
        this.stockFacade = stockFacade;
    }

    public void setInvoiceFacade(final InvoiceFacade invoiceFacade)
    {
        this.invoiceFacade = invoiceFacade;
    }

}
