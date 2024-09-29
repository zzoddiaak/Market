package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.booking.BookingFullDto;
import homework.entity.Bookings;
import homework.repository.api.BookingsRepository;
import homework.service.BookingsService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(
        classes = {AppConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
class BookingsServiceImplTest {

    @InjectMocks
    private BookingsServiceImpl bookingsService;

    @Spy
    private BookingsRepository bookingsRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        Bookings booking1 = Bookings.builder()
                .id(1L)
                .status("CONFIRMED")
                .build();
        Bookings booking2 = Bookings.builder()
                .id(2L)
                .status("PENDING")
                .build();

        when(bookingsRepository.findAll()).thenReturn(List.of(booking1, booking2));

        BookingFullDto dto1 = new BookingFullDto();
        dto1.setStatus("CONFIRMED");
        BookingFullDto dto2 = new BookingFullDto();
        dto2.setStatus("PENDING");

        when(mapper.convertToDto(booking1, BookingFullDto.class)).thenReturn(dto1);
        when(mapper.convertToDto(booking2, BookingFullDto.class)).thenReturn(dto2);

        List<BookingFullDto> actual = bookingsService.findAll();

        verify(bookingsRepository, times(1)).findAll();
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        assertEquals("CONFIRMED", actual.get(0).getStatus());
        assertEquals("PENDING", actual.get(1).getStatus());
    }

    @Test
    void findById() {
        long id = 1L;
        Bookings booking = Bookings.builder()
                .id(id)
                .status("CONFIRMED")
                .build();

        when(bookingsRepository.findById(id)).thenReturn(booking);

        BookingFullDto expectedDto = new BookingFullDto();
        expectedDto.setStatus("CONFIRMED");

        when(mapper.convertToDto(booking, BookingFullDto.class)).thenReturn(expectedDto);

        BookingFullDto actual = bookingsService.findById(id);

        verify(bookingsRepository, times(1)).findById(id);
        assertNotNull(actual);
        assertEquals(expectedDto.getStatus(), actual.getStatus());
    }

    @Test
    void save() {
        BookingFullDto bookingDto = new BookingFullDto();
        bookingDto.setStatus("CONFIRMED");

        Bookings booking = Bookings.builder()
                .status("CONFIRMED")
                .build();

        when(mapper.convertToEntity(bookingDto, Bookings.class)).thenReturn(booking);

        doNothing().when(bookingsRepository).save(any(Bookings.class));

        bookingsService.save(bookingDto);

        verify(bookingsRepository, times(1)).save(booking);
    }

    @Test
    void update() {
        long id = 1L;
        BookingFullDto updateDto = new BookingFullDto();
        updateDto.setStatus("UPDATED");

        Bookings existingBooking = Bookings.builder()
                .id(id)
                .status("CONFIRMED")
                .build();

        Bookings updatedBooking = Bookings.builder()
                .id(id)
                .status("UPDATED")
                .build();

        when(bookingsRepository.findById(id)).thenReturn(existingBooking);
        when(mapper.convertToEntity(updateDto, Bookings.class)).thenReturn(updatedBooking);

        doNothing().when(bookingsRepository).update(any(Bookings.class));

        bookingsService.update(id, updateDto);

        verify(bookingsRepository, times(1)).update(updatedBooking);
    }

    @Test
    void deleteById() {
        long id = 1L;

        bookingsService.deleteById(id);

        verify(bookingsRepository, times(1)).deleteById(id);
    }
}
