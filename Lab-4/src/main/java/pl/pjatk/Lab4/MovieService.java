package pl.pjatk.Lab4;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    public MovieService() {

    }
    public List<Movie> getAll() {

        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1L, "Shrek", "Animation"));
        movies.add(new Movie(2L, "Shrek 2", "Animation"));
        movies.add(new Movie(3L, "Shrek Trzeci", "Animation"));
        return movies;
    }
}
