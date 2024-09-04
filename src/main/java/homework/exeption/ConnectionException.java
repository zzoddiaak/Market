package homework.exeption;

public class ConnectionException extends RuntimeException {
    public ConnectionException() {
        super("Transaction already opened for this thread.");
    }
}
