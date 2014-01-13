package workshop.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations="classpath:META-INF/spring.xml")
@Test(groups="states")
public class StateBeanTest extends AbstractTestNGSpringContextTests{
	@Autowired
	private StateBean target;
	
	@Test
	public void test()
	{
		
	}
}
