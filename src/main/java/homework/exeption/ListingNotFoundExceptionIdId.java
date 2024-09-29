package homework.exeption;

public class ListingNotFoundExceptionIdId extends RuntimeException {
    private static final String message ="Listing %s not found";
    public ListingNotFoundExceptionIdId(Long id) {
        super(String.format(message, id));
    }
}
