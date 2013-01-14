package workshop.spring.config.movie.interfaces;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import workshop.spring.config.movie.Movie;
import au.com.bytecode.opencsv.CSVReader;

public class CsvMovieFinder implements MovieFinder
{
    private final static Logger LOGGER = LoggerFactory.getLogger(CsvMovieFinder.class);
    private static final String MOVIES_FILE = "src/test/resources/movies.txt";

    @Override
    public List<Movie> getMovies()
    {
        List<Movie> list = new ArrayList<Movie>();
        CSVReader reader;
        try
        {
            reader = new CSVReader(new FileReader(MOVIES_FILE), '|');
        }
        catch (FileNotFoundException e)
        {
            throw new RuntimeException("File:"+MOVIES_FILE+" does not exist", e);
        }
        String[] nextLine;
        try
        {
            while ((nextLine = reader.readNext()) != null)
            {
                if (nextLine.length != 3)
                {
                    throw new RuntimeException("Expected 3 columns in csv, got " + nextLine.length);
                }
                list.add(new Movie(nextLine[0], nextLine[1], nextLine[2]));
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("Error reading file:"+MOVIES_FILE, e);
        }
        finally
        {
            try
            {
                reader.close();
            }
            catch (IOException e)
            {
                LOGGER.error("Error closing file {}", MOVIES_FILE, e);
            }
        }
        return list;
    }

}
