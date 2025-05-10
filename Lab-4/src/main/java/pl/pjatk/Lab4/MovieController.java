package pl.pjatk.Lab4;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {
    MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public ResponseEntity<List<Movie>> getMovie() {
        return ResponseEntity.ok(movieService.getAll());

    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id)
    {
        Long idL = (long) id;
        Movie movie = movieService.getMovieById(idL);
        if (movie != null) return ResponseEntity.ok(movie);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping()
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie)
    {
        try
        {
            movieService.add(movie);
            return ResponseEntity.ok(movie);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie updatedMovie)
    {
        if (movieService.getMovieById(id) == null) return ResponseEntity.notFound().build();
        try
        {
            movieService.updateMovie(id, updatedMovie);
            return ResponseEntity.ok(updatedMovie);
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id)
    {
        if (movieService.getMovieById(id) == null) return ResponseEntity.notFound().build();
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
