package pl.pjatk.Lab4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    List<Movie> movies = new ArrayList<>();

    public MovieService() {
        movies.add(new Movie("Shrek", "Animation", 89L));
        movies.add(new Movie("Shrek 2", "Animation", 93L));
        movies.add(new Movie("Shrek Trzeci", "Animation", 93L));

    }
    public List<Movie> getAll() {
        return movies;
    }

    public Movie getMovieById(Long id)
    {
        for (Movie movie : movies) {
            if (movie.getId().equals(id)) return movie;
        }
        return null;
    }

    public void add(Movie movie)
    {
        movies.add(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie)
    {
        for (Movie movie : movies) {
            if (movie.getId().equals(id))
            {
                movie.setTitle(updatedMovie.getTitle());
                movie.setCategory(updatedMovie.getCategory());
                movie.setDuration(updatedMovie.getDuration());
                return movie;
            }
        }
        return null;
    }

    public void deleteMovie(Long id)
    {
        movies.remove(getMovieById(id));
    }
}
