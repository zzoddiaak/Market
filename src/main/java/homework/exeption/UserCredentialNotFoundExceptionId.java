package homework.exeption;

public class UserCredentialNotFoundExceptionId extends RuntimeException {
    public UserCredentialNotFoundExceptionId(Long id) {
        super(String.format("Credential %s not found", id));
    }
}
