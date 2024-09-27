package homework.exeption;

public class UserNotFoundExceptionId extends RuntimeException {
    public UserNotFoundExceptionId(Long id) {
        super("User " + id + " not found");
    }
}
