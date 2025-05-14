package pl.pjatk.Lab4;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();
    Optional<Movie> findById(long id);
    Movie save(Movie movie);
    void deleteById(long id);
}
