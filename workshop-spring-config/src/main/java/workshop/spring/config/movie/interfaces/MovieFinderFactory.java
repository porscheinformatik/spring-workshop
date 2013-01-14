package workshop.spring.config.movie.interfaces;

public class MovieFinderFactory
{
    public enum Finder
    {
        HARDCODED, CSV;
    };
    
    MovieFinder getFinder(Finder finder)
    {
        if (finder.equals(Finder.HARDCODED))
        {
            return new HardcodedMovieFinder();
        }
        else if (finder.equals(Finder.CSV))
        {
            return new CsvMovieFinder();
        }
        throw new RuntimeException("Finder for "+finder.toString()+" not implemented");
    }
}
