package workshop.spring.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations="classpath:META-INF/spring-data-spring.xml") 
public class CrmFacadeIoCTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private CrmFacade target;
    
    @Test
    public void reportFindAll() 
    {
        target.reportFindAll();
    }
}
