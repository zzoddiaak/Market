package homework.exeption;

public class CategoryNotFoundExceptionId extends RuntimeException {
    private static final String message = "Category %s not found";
    public CategoryNotFoundExceptionId(Long id) {
        super(String.format(message, id));
    }
}
