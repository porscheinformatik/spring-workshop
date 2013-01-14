package workshop.spring.config.movie.interfaces;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MovieListerTest
{
    @Test
    public void moviesReport()
    {
        MovieLister target = new MovieLister();
        String report = target.moviesReport();
        Assert.assertNotNull(report);
        System.out.println(report);
    }
}
