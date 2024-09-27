package homework.exeption;

public class BookingsNotFoundExceptionId extends RuntimeException {
    public BookingsNotFoundExceptionId(Long id) {
        super(String.format("Bookings %s not found", id));
    }
}
