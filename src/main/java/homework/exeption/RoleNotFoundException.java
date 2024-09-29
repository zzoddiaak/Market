package homework.exeption;

public class RoleNotFoundException extends RuntimeException {
    private static final String message = "Role %s not found";
    public RoleNotFoundException(Long id) {
        super(String.format(message, id));
    }
}
