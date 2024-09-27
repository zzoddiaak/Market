package homework.exeption;

public class RoleNotFoundException extends RuntimeException {
    public RoleNotFoundException(Long id) {
        super(String.format("Role %s not found", id));
    }
}
