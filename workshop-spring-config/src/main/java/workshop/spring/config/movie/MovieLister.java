package workshop.spring.config.movie;


public class MovieLister
{
    public String moviesReport()
    {
        StringBuilder bld = new StringBuilder();
        bld.append("Wir haben folgende Filme:");
        bld.append("Film\tJahr\tRegisseur\n");
        MovieFinder movieFinder = new MovieFinder();
        for (Movie movie : movieFinder.getMovies())
        {
            bld.append(movie.getTitle()).append("\t");
            bld.append(movie.getProductionYear()).append("\t");
            bld.append(movie.getDirector()).append("\n");
        }
        return bld.toString();
    }
    
}
