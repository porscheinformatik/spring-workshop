package workshop.spring.config;

public interface StockFacade
{
    boolean itemOnStock(String item);
    
    void orderItem(String item);
}
