package workshop.spring.config.movie.spring;

import workshop.spring.config.movie.Movie;
import workshop.spring.config.movie.interfaces.MovieFinder;


public class MovieLister
{
    private final MovieFinder movieFinder;
    public MovieLister(final MovieFinder movieFinder)
    {
        this.movieFinder = movieFinder;
    }
    public String moviesReport()
    {
        StringBuilder bld = new StringBuilder();
        bld.append("Wir haben folgende Filme:");
        bld.append("Film\tJahr\tRegisseur\n");
        for (Movie movie : movieFinder.getMovies())
        {
            bld.append(movie.getTitle()).append("\t");
            bld.append(movie.getProductionYear()).append("\t");
            bld.append(movie.getDirector()).append("\n");
        }
        return bld.toString();
    }
    
}
