package homework.exeption;

public class ListingRequestNotFoundExceptionId extends RuntimeException {
    public ListingRequestNotFoundExceptionId(Long id) {
        super(String.format("Request %s not found", id));
    }
}
