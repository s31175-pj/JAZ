package pl.pjatk.RentalService.exceptions;

public class MovieServiceConnectionFailedException extends RuntimeException
{
    public MovieServiceConnectionFailedException(String message, Throwable cause)
    {
        super(message);
    }
}
