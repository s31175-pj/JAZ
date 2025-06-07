package pl.pjatk.RentalService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import pl.pjatk.RentalService.exceptions.InvalidMovieRequestException;
import pl.pjatk.RentalService.exceptions.MovieNotFoundException;
import pl.pjatk.RentalService.exceptions.MovieServiceConnectionFailedException;
import pl.pjatk.RentalService.exceptions.MovieServiceUnavailableException;

@Service
public class RentalService {
    RestTemplate restTemplate;

    public RentalService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovie(Long id) {
        String url = "http://localhost:8080/movies/"+id;

        return getMovie(id, url);
    }

    public Movie returnMovie(Long id) {
        String url = "http://localhost:8080/movies/available/" + id;

        return getMovie(id, url);

//        try {
//            return restTemplate.getForObject(url, Movie.class);
//        } catch (HttpClientErrorException e) {
//            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
//                throw new MovieNotFoundException("Movie with ID " + id + " not found (return operation).");
//            } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
//                throw new InvalidMovieRequestException("Invalid request for movie ID " + id + " (return operation): " + e.getResponseBodyAsString());
//            } else {
//                throw new InvalidMovieRequestException("Client error from MovieService (" + e.getStatusCode() + ") for ID " + id + " (return operation): " + e.getResponseBodyAsString());
//            }
//        } catch (HttpServerErrorException e) {
//            throw new MovieServiceUnavailableException("MovieService returned a server error (" + e.getStatusCode() + ") (return operation): " + e.getResponseBodyAsString(), e);
//        } catch (ResourceAccessException e) {
//            if (e.getCause() instanceof java.net.ConnectException) {
//                throw new MovieServiceConnectionFailedException("Could not connect to MovieService (return operation) at " + url + ": " + e.getMessage(), e);
//            }
//            throw new MovieServiceConnectionFailedException("Resource access error during call to MovieService (return operation): " + e.getMessage(), e);
//        } catch (Exception e) {
//            throw new RuntimeException("An unexpected error occurred during movie return operation: " + e.getMessage(), e);
//        }
    }

    public Movie rentMovie(Long id) {
        String url = "http://localhost:8080/movies/unavailable/" + id;

        return getMovie(id, url);

//        try {
//            return restTemplate.getForObject(url, Movie.class);
//        } catch (HttpClientErrorException e) {
//            if (e.getStatusCode() == HttpStatus.NOT_FOUND) {
//                throw new MovieNotFoundException("Movie with ID " + id + " not found (return operation).");
//            } else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) {
//                throw new InvalidMovieRequestException("Invalid request for movie ID " + id + " (return operation): " + e.getResponseBodyAsString());
//            } else {
//                throw new InvalidMovieRequestException("Client error from MovieService (" + e.getStatusCode() + ") for ID " + id + " (return operation): " + e.getResponseBodyAsString());
//            }
//        } catch (HttpServerErrorException e) {
//            throw new MovieServiceUnavailableException("MovieService returned a server error (" + e.getStatusCode() + ") (return operation): " + e.getResponseBodyAsString(), e);
//        } catch (ResourceAccessException e) {
//            if (e.getCause() instanceof java.net.ConnectException) {
//                throw new MovieServiceConnectionFailedException("Could not connect to MovieService (return operation) at " + url + ": " + e.getMessage(), e);
//            }
//            throw new MovieServiceConnectionFailedException("Resource access error during call to MovieService (return operation): " + e.getMessage(), e);
//        } catch (Exception e) {
//            throw new RuntimeException("An unexpected error occurred during movie return operation: " + e.getMessage(), e);
//        }
    }

    private Movie getMovie(Long id, String url) {
        try
        {
            return restTemplate.getForObject(url, Movie.class);
        }
        catch (HttpClientErrorException e)
        {
            if(e.getStatusCode() == HttpStatus.NOT_FOUND) throw new MovieNotFoundException("Movie with id: " + id + " not found");
            else if (e.getStatusCode() == HttpStatus.BAD_REQUEST) throw new InvalidMovieRequestException("Invalid request for movie id: " + id);
            else throw new InvalidMovieRequestException("Client error from Movie Service " + e.getStatusCode() + "for movie id: " + id);
        }
        catch (HttpServerErrorException e)
        {
            throw new MovieServiceUnavailableException("Server error from Movie Service " + e.getStatusCode() + ": " + e.getResponseBodyAsString(), e);
        }
        catch (ResourceAccessException e)
        {
            if(e.getCause() instanceof java.net.ConnectException)
            {
                throw new MovieServiceConnectionFailedException("Could not connect to MovieService at url: " + url + " " + e.getMessage(), e);
            }
            throw new MovieServiceConnectionFailedException("Resource access error during call to MovieService: " + e.getMessage(), e);
        }
        catch (Exception e)
        {
            throw new RuntimeException("An unexpected error occurred while communicating with MovieService: " + e.getMessage(), e);
        }
    }

}
