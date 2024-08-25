package homework.repository.api;

import homework.entity.Bookings;

import java.util.List;

public interface BookingsRepository {
    Bookings findById(Long id);
    List<Bookings> findAll();
    void save(Bookings bookings);
    void deleteById(Long id);

}
