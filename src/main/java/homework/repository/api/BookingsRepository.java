package homework.repository.api;

import homework.dto.booking.BookingFullDto;
import homework.entity.Bookings;

import java.util.List;

public interface BookingsRepository {
    Bookings findById(Long id);
    List<Bookings> findAll();
    void save(Bookings bookings);
    void deleteById(Long id);
    void update(Bookings bookings);
    List<Bookings> findAllWithAssociationsEntityGraph();
    List<Bookings> findAllWithAssociationsCriteria();
    List<Bookings> findByStatusJPQL(String status);
}
