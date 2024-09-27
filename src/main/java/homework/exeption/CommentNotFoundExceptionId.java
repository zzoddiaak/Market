package homework.exeption;

public class CommentNotFoundExceptionId extends RuntimeException {
    public CommentNotFoundExceptionId(Long id) {
        super(String.format("Comment %s not found", id));
    }
}
