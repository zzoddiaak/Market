package homework.exeption;

public class CategoryNotFoundExceptionId extends RuntimeException {
    public CategoryNotFoundExceptionId(Long id) {
        super(String.format("Category %s not found", id));
    }
}
