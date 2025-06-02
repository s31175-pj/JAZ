package pl.pjatk.RentalService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RentalService {
    RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        return restTemplate.getForObject("http://localhost:8080/movies/"+id+"/", Movie.class);
    }

    public Movie returnMovie(Long id) {
        return restTemplate.getForObject("http://localhost:8080/movies/available/"+id+"/", Movie.class);
    }

}
