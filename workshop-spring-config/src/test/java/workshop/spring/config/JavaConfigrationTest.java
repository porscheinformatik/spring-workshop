package workshop.spring.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.testng.annotations.Test;

public class JavaConfigrationTest
{
    @Test
    public void processOrder()
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfigurator.class);
        OrderManager target = ctx.getBean(OrderManager.class);
        target.processOrder();
    }

}
