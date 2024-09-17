package homework.repository.impl;

import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.Bookings;
import homework.repository.api.BookingsRepository;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class, LiquibaseConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class BookingsRepositoryImplTest {

    @Resource
    private BookingsRepository bookingsRepository;

    @Test
    public void findByStatusJPQL() {
        Bookings booking = Bookings.builder().status("CONFIRMED").build();
        bookingsRepository.save(booking);

        List<Bookings> bookings = bookingsRepository.findByStatusJPQL("CONFIRMED");
        assertNotNull(bookings);
        assertFalse(bookings.isEmpty());

        bookings.forEach(b -> assertEquals("CONFIRMED", b.getStatus()));
    }

    @Test
    public void findAllWithAssociationsCriteria() {
        List<Bookings> bookings = bookingsRepository.findAllWithAssociationsCriteria();
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


