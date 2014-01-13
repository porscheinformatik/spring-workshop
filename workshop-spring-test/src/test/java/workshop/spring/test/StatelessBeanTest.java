package workshop.spring.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@ContextConfiguration(locations= {"classpath:spring.test.xml"})
public class StatelessBeanTest extends AbstractTestNGSpringContextTests{
	@Autowired
	private StatelessBean target;
	
	@Test
	public void test()
	{
		
	}
}
