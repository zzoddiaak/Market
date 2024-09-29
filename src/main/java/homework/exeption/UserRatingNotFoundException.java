package homework.exeption;

public class UserRatingNotFoundException extends RuntimeException {
    private static final String message = "Rating %s not found";
    public UserRatingNotFoundException(Long id) {
        super(String.format(message, id));
    }
}
