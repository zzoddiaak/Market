package homework.repository.impl;

import homework.config.test.TestConfig;
import homework.entity.Bookings;
import homework.repository.api.BookingsRepository;
import jakarta.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired; // Make sure to import this
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class}) // Ensure this is correct
@Transactional
@ActiveProfiles("test")
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
    public void findAllWithAssociationsEntityGraph() {
        List<Bookings> bookings = bookingsRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());
    }
}
