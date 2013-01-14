package workshop.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfigurator
{
    @Bean
    public InvoiceFacade invoiceFacade()
    {
        return new FakeInvoiceFacade();
    }
    
    @Bean
    public StockFacade stockFacade()
    {
        return new FakeStockFacade();
    }
    
    @Bean 
    public OrderManager orderManager()
    {
        return new OrderManagerConstructorInjection(stockFacade(), invoiceFacade());
    }
}
