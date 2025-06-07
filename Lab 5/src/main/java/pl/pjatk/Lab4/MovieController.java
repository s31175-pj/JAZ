package pl.pjatk.Lab4;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
@Schema(description = "Movie operations")
public class MovieController {
    MovieService movieService;
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    @Tag(name = "wszystkie filmy")
    @Operation(summary = "dodaj film", description = "zwraca wszystkie filmy w postaci JSON")
    @ApiResponse(        responseCode = "200",        description = "poprawna tresc zwrotna")
    @ApiResponse(        responseCode = "404",        description = "brak filmu")
    @ApiResponse(        responseCode = "400",        description = "blad, zle zformulowany request")
    @ApiResponse(        responseCode = "500",        description = "blad zewntrzny")
    public ResponseEntity<List<Movie>> getMovie() {
        return ResponseEntity.ok(movieService.getAll());

    }

    @GetMapping("{id}")
    @Tag(name = "podaj film po id")
    public ResponseEntity<Movie> getMovieById(@PathVariable int id)
    {
        Long idL = (long) id;
        Movie movie = movieService.getMovieById(idL);
        if (movie != null) return ResponseEntity.ok(movie);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping()
    @Tag(name = "dodaj film")
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
    @Tag(name = "zmień film")
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
    @Tag(name = "usuń film")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id)
    {
        if (movieService.getMovieById(id) == null) return ResponseEntity.notFound().build();
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("available/{id}")
    @Tag(name = "zmień dostępność filmu na true")
    public ResponseEntity<Movie> updateMovieAvailable(@PathVariable Long id)
    {
        if (movieService.getMovieById(id) == null) return ResponseEntity.notFound().build();
        try
        {
            return ResponseEntity.ok(movieService.returnMovie(id));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("unavailable/{id}")
    @Tag(name = "zmień dostępność filmu na false")
    public ResponseEntity<Movie> updateMovieUnvailable(@PathVariable Long id)
    {
        if (movieService.getMovieById(id) == null) return ResponseEntity.notFound().build();
        try
        {
            return ResponseEntity.ok(movieService.rentMovie(id));
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
