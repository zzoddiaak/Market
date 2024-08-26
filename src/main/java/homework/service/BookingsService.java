package homework.service;

import homework.dto.booking.BookingFullDto;
import java.util.List;

public interface BookingsService {

    List<BookingFullDto> findAll();
    BookingFullDto findById(long id);
    void save(BookingFullDto object);
    void update(long id, BookingFullDto updateDTO);
    void deleteById(long id);
}
