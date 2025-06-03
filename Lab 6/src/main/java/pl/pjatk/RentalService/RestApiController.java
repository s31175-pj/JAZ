package pl.pjatk.RentalService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("movies")
public class RestApiController {
    RentalService rentalService;

    public RestApiController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Movie> getMovie(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getMovie(id));
    }

    @GetMapping("available/{id}")
    public ResponseEntity<Movie> updateMovieAvailable(@PathVariable Long id)
    {
        return ResponseEntity.ok(rentalService.returnMovie(id));
    }

    @GetMapping("unavailable/{id}")
    public ResponseEntity<Movie> updateMovieUnavailable(@PathVariable Long id)
    {
        return ResponseEntity.ok(rentalService.rentMovie(id));
    }
}
