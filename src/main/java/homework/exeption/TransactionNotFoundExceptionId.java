package homework.exeption;

public class TransactionNotFoundExceptionId extends RuntimeException {
    private static final String message ="Transaction %s not found";
    public TransactionNotFoundExceptionId(Long id) {
        super(String.format(message, id));    }
}
