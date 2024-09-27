package homework.exeption;

public class ListingNotFoundExceptionIdId extends RuntimeException {
    public ListingNotFoundExceptionIdId(Long id) {
        super(String.format("Listing %s not found", id));
    }
}
