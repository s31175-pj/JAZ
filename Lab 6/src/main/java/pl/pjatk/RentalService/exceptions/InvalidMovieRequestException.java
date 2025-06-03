package pl.pjatk.RentalService.exceptions;

public class InvalidMovieRequestException extends RuntimeException
{
    public InvalidMovieRequestException(String message)
    {
        super(message);
    }
}
