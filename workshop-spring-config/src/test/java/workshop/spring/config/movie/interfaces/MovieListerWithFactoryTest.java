package workshop.spring.config.movie.interfaces;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieListerWithFactoryTest
{
    @Test
    public void moviesReport()
    {
        MovieListerWithFactory target = new MovieListerWithFactory();
        String report = target.moviesReport();
        Assert.assertNotNull(report);
        System.out.println(report);
    }
}
