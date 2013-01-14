package workshop.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations="classpath:META-INF/autowire-setter-spring.xml")
public class AutowireSetterInjectionTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private OrderManager target;
    
    @Test
    public void processOrder()
    {
        target.processOrder();
    }
}
