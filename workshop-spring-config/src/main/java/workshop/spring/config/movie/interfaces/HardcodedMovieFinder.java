package workshop.spring.config.movie.interfaces;

import java.util.Arrays;
import java.util.List;

import workshop.spring.config.movie.Movie;

public class HardcodedMovieFinder implements MovieFinder
{

    @Override
    public List<Movie> getMovies()
    {
        return Arrays.asList(new Movie("The Fellowship of the Ring", "2001", "Peter Jackson")
        , new Movie("The Two Towers", "2002", "Peter Jackson")
        , new Movie("The Return of the King", "2003", "Peter Jackson"));
    }

}
