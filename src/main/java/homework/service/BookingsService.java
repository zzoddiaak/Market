package homework.service;

import homework.dto.booking.BookingFullDto;
import java.util.List;

public interface BookingsService {

    List<BookingFullDto> findAll();
    BookingFullDto findById(long id);
    void save(BookingFullDto object);
    void deleteById(long id);
    void update(long id, BookingFullDto updateDTO);

}
