package homework.repository.impl;

import homework.config.TestConfig;
import homework.entity.Bookings;
import homework.repository.api.BookingsRepository;
import jakarta.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class BookingsRepositoryImplTest {

    @Resource
    private BookingsRepository bookingsRepository;

    @Before
    public void setUp() {
        Bookings booking = Bookings.builder()
                .status("CONFIRMED")
                .build();
        bookingsRepository.save(booking);
    }

    @Test
    public void findByStatusJPQL() {
        List<Bookings> bookings = bookingsRepository.findByStatusJPQL("CONFIRMED");
        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());
        bookings.forEach(b -> assertEquals("CONFIRMED", b.getStatus()));
    }

    @Test
    public void findAllWithAssociationsCriteria() {
        List<Bookings> bookings = bookingsRepository.findAllWithAssociationsCriteria();
        System.out.println("Bookings size: " + bookings.size()); // Выведите размер списка
        for (Bookings booking : bookings) {
            System.out.println("Booking ID: " + booking.getId()); // Выведите ID каждого бронирования
        }
        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<Bookings> bookings = bookingsRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());
    }
}
