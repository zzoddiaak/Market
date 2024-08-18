package homework.exeption;

public class ObjectInstantiationException extends RuntimeException {
    public ObjectInstantiationException(String message, Exception e) {
        super(message, e);
    }
}

