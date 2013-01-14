package workshop.spring.config.movie.interfaces;

import workshop.spring.config.movie.Movie;
import workshop.spring.config.movie.interfaces.MovieFinderFactory.Finder;


public class MovieListerWithFactory
{
    private final MovieFinderFactory factory = new MovieFinderFactory();
    public String moviesReport()
    {
        StringBuilder bld = new StringBuilder();
        bld.append("Wir haben folgende Filme:");
        bld.append("Film\tJahr\tRegisseur\n");
        MovieFinder movieFinder = factory.getFinder(Finder.CSV);
        for (Movie movie : movieFinder.getMovies())
        {
            bld.append(movie.getTitle()).append("\t");
            bld.append(movie.getProductionYear()).append("\t");
            bld.append(movie.getDirector()).append("\n");
        }
        return bld.toString();
    }
    
}
