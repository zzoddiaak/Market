package homework.exeption;

public class UserRatingNotFoundException extends RuntimeException {
    public UserRatingNotFoundException(Long id) {
        super(String.format("Rating %s not found", id));
    }
}
