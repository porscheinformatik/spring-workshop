package workshop.spring.aop;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations="classpath:aop.test.spring.xml")
public class EntryExitLoggingTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private OrderManager target;
    
    @Test
    public void log()
    {
        target.order(Arrays.asList("item1", "item2", "item3"));
    }
}
