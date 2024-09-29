package homework.exeption;

public class ListingRequestNotFoundExceptionId extends RuntimeException {
    private static final String message = "Request %s not found";
    public ListingRequestNotFoundExceptionId(Long id) {
        super(String.format(message, id));
    }
}
