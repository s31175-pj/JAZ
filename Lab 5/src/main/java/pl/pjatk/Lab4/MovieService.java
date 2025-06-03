package pl.pjatk.Lab4;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    public List<Movie> getAll() {
        return movieRepository.findAll();
    }

    public Movie getMovieById(Long id)
    {
        if(movieRepository.findById(id).isPresent()) return movieRepository.findById(id).get();
        else return null;
    }

    public void add(Movie movie)
    {
        movieRepository.save(movie);
    }

    public Movie updateMovie(Long id, Movie updatedMovie)
    {
        if(movieRepository.findById(id).isPresent())
        {
            Movie movie = movieRepository.findById(id).get();
            movie.setTitle(updatedMovie.getTitle());
            movie.setCategory(updatedMovie.getCategory());
            movie.setDuration(updatedMovie.getDuration());
            movieRepository.save(movie);
            return movie;
        }
        return null;
    }

    public void deleteMovie(Long id) { movieRepository.deleteById(id); }

    public Movie returnMovie(Long id)
    {
        if(movieRepository.findById(id).isPresent())
        {
            Movie movie = movieRepository.findById(id).get();
            movie.setAvailable();
            movieRepository.save(movie);
            return movie;
        }
        return null;
    }

    public Movie rentMovie(Long id)
    {
        if(movieRepository.findById(id).isPresent())
        {
            Movie movie = movieRepository.findById(id).get();
            movie.setUnavailable();
            movieRepository.save(movie);
            return movie;
        }
        return null;
    }
}
