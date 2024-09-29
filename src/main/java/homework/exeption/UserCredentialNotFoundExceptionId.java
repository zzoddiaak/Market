package homework.exeption;

public class UserCredentialNotFoundExceptionId extends RuntimeException {
    private static final String message = "Credential %s not found";
    public UserCredentialNotFoundExceptionId(Long id) {
        super(String.format(message, id));
    }
}
