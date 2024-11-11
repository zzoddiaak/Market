package homework.repository.impl;

import homework.config.test.TestConfig;
import homework.entity.Bookings;
import homework.repository.api.BookingsRepository;
import jakarta.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
@ActiveProfiles("test")
public class BookingsRepositoryImplTest {

    @Resource
    private BookingsRepository bookingsRepository;

    @Before
    public void setUp() {
        Bookings booking = Bookings.builder()
                .status("CONFIRMED")
                .startDate(LocalDate.now().minusDays(5))
                .endDate(LocalDate.now().plusDays(5))
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
    public void findAllWithAssociationsEntityGraph() {
        List<Bookings> bookings = bookingsRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());
    }

    @Test
    public void findBookingsInPeriod() {
        LocalDate startDate = LocalDate.now().minusDays(10);
        LocalDate endDate = LocalDate.now().plusDays(10);

        List<Bookings> bookings = bookingsRepository.findBookingsInPeriod(startDate, endDate);

        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());

        bookings.forEach(b -> {
            assertTrue(b.getStartDate().isAfter(startDate.minusDays(1)) || b.getStartDate().isEqual(startDate));
            assertTrue(b.getEndDate().isBefore(endDate.plusDays(1)) || b.getEndDate().isEqual(endDate));
        });
    }



    @Test
    public void findExpiringBookings() {
        int days = 10;
        List<Bookings> bookings = bookingsRepository.findExpiringBookings(days);

        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());

        LocalDate now = LocalDate.now();
        LocalDate expiryDate = now.plusDays(days);

        bookings.forEach(b -> {
            assertTrue(b.getEndDate().isBefore(expiryDate.plusDays(1)) && b.getEndDate().isAfter(now.minusDays(1)));
        });
    }
}
