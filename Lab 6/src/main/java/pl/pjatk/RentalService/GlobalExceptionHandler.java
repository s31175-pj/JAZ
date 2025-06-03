package pl.pjatk.RentalService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import pl.pjatk.RentalService.exceptions.InvalidMovieRequestException;
import pl.pjatk.RentalService.exceptions.MovieNotFoundException;
import pl.pjatk.RentalService.exceptions.MovieServiceConnectionFailedException;
import pl.pjatk.RentalService.exceptions.MovieServiceUnavailableException;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    public static class ErrorResponse
    {
        private LocalDateTime timestamp;
        private int status;
        private String error;
        private String message;
        private String path;

        public ErrorResponse(HttpStatus status, String error, String message, String path)
        {
            this.timestamp = LocalDateTime.now();
            this.status = status.value();
            this.error = status.getReasonPhrase();
            this.message = message;
            this.path = path;
        }

        public LocalDateTime getTimestamp() {return timestamp;}
        public int getStatus() {return status;}
        public String getError() {return error;}
        public String getMessage() {return message;}
        public String getPath() {return path;}
    }

    @ExceptionHandler(MovieNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleMovieNotFoundException(MovieNotFoundException ex, WebRequest request)
    {
        logger.warn("Movie Not Found: {}", ex);
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.NOT_FOUND,
                ex.toString(),
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InvalidMovieRequestException.class)
    public ResponseEntity<ErrorResponse> handleInvalidMovieRequestException(InvalidMovieRequestException ex, WebRequest request)
    {
        logger.warn("Invalid Movie Request: {}", ex);
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_REQUEST,
                ex.toString(),
                ex.getMessage(),
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MovieServiceUnavailableException.class)
    public ResponseEntity<ErrorResponse> handleMovieServiceUnavailableException(MovieServiceUnavailableException ex, WebRequest request)
    {
        logger.warn("MovieService Unavailable (5xx from external service): {}", ex);
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.BAD_GATEWAY,
                ex.toString(),
                "External MovieService returned an error.",
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(MovieServiceConnectionFailedException.class)
    public ResponseEntity<ErrorResponse> handleMovieServiceConnectionFailedException(MovieServiceConnectionFailedException ex, WebRequest request)
    {
        logger.warn("Failed to connect to MovieService: {}", ex);
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.GATEWAY_TIMEOUT,
                ex.toString(),
                "Could not connect to external MovieService. Please try again later.",
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.GATEWAY_TIMEOUT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request)
    {
        logger.warn("An unexpected internal server error occurred: {}", ex);
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR,
                ex.toString(),
                "An unexpected error occurred. Please try again later.",
                request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
