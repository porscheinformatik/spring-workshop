package workshop.spring.config.movie.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;


@ContextConfiguration(locations="classpath:META-INF/movie.spring.xml")
public class MovieListerIoCTest extends AbstractTestNGSpringContextTests
{
    @Autowired
    private MovieLister target;
    
    @Test
    public void moviesReport()
    {
        String report = target.moviesReport();
        Assert.assertNotNull(report);
        System.out.println(report);
    }
}
