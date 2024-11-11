package homework.repository.api;

import homework.dto.booking.BookingFullDto;
import homework.entity.Bookings;

import java.time.LocalDate;
import java.util.List;

public interface BookingsRepository {
    Bookings findById(Long id);
    List<Bookings> findAll();
    void save(Bookings bookings);
    void deleteById(Long id);
    void update(Bookings bookings);
    List<Bookings> findAllWithAssociationsEntityGraph();
    List<Bookings> findByStatusJPQL(String status);
    List<Bookings> findBookingsInPeriod(LocalDate startDate, LocalDate endDate);
    List<Bookings> findByUserAndStatus(Long userId, String status);
    List<Bookings> findExpiringBookings(int days);
    List<Bookings> findByListingCount(int listingCount);
    int updateStatusForBookings(String currentStatus, String newStatus);
}
