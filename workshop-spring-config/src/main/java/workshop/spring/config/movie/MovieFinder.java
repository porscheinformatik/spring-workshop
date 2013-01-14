package workshop.spring.config.movie;

import java.util.Arrays;
import java.util.List;

public class MovieFinder
{
    public List<Movie> getMovies()
    {
        return Arrays.asList(new Movie("The Fellowship of the Ring", "2001", "Peter Jackson")
            , new Movie("The Two Towers", "2002", "Peter Jackson")
            , new Movie("The Return of the King", "2003", "Peter Jackson"));
    }
}
