package homework.exeption;

public class CommentNotFoundExceptionId extends RuntimeException {
    private static final String message = "Comment %s not found";
    public CommentNotFoundExceptionId(Long id) {
        super(String.format(message, id));
    }
}
