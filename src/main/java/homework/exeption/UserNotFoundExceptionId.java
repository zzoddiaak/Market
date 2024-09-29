package homework.exeption;

public class UserNotFoundExceptionId extends RuntimeException {
    private static final String message = "User not found: ";
    public UserNotFoundExceptionId(Long id) {
        super(String.format(message, id));
    }
}
