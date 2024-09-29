package homework.exeption;

public class BookingsNotFoundExceptionId extends RuntimeException {
    private static final String message = "Bookings %s not found";

    public BookingsNotFoundExceptionId(Long id) {
        super(String.format(message, id));
    }
}
