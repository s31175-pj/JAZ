package pl.pjatk.pt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieController {

    @GetMapping("all")
    public ResponseEntity<List<Movie>> getMovie() {
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1L, "Shrek", "Animation"));
        movies.add(new Movie(2L, "Shrek 2", "Animation"));
        movies.add(new Movie(3L, "Shrek Trzeci", "Animation"));
        return new ResponseEntity<>(movies, HttpStatus.OK);

    }
}
