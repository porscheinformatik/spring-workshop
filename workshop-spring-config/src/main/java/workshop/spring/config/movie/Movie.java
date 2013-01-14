package workshop.spring.config.movie;

public class Movie
{
    private final String title;
    private final String productionYear;
    private final String director;
    public Movie(String title, String productionYear, String director)
    {
        this.title = title;
        this.productionYear = productionYear;
        this.director = director;
    }
    public String getTitle()
    {
        return title;
    }
    public String getProductionYear()
    {
        return productionYear;
    }
    public String getDirector()
    {
        return director;
    }
}
