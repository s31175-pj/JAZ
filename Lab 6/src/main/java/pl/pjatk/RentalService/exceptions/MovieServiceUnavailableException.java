package pl.pjatk.RentalService.exceptions;

public class MovieServiceUnavailableException extends RuntimeException
{
    public MovieServiceUnavailableException(String message, Throwable cause)
    {
        super(message);
    }
}
