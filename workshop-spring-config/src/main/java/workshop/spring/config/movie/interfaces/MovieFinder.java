package workshop.spring.config.movie.interfaces;

import java.util.List;

import workshop.spring.config.movie.Movie;

public interface MovieFinder
{
    List<Movie> getMovies();
}
