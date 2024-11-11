package homework.service;

import homework.dto.booking.BookingFullDto;

import java.time.LocalDate;
import java.util.List;

public interface BookingsService {

    List<BookingFullDto> findAll();
    BookingFullDto findById(long id);
    void save(BookingFullDto object);
    void deleteById(long id);
    void update(long id, BookingFullDto updateDTO);
    List<BookingFullDto> findBookingsInPeriod(LocalDate startDate, LocalDate endDate);
    List<BookingFullDto> findByUserAndStatus(Long userId, String status);
    List<BookingFullDto> findExpiringBookings(int days);

}
