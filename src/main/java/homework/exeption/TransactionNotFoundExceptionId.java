package homework.exeption;

public class TransactionNotFoundExceptionId extends RuntimeException {
    public TransactionNotFoundExceptionId(Long id) {
        super(String.format("Transaction %s not found", id));    }
}
