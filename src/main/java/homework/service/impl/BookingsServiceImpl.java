package homework.service.impl;

import homework.dto.DtoMapper;
import homework.dto.booking.BookingFullDto;
import homework.entity.Bookings;
import homework.repository.api.BookingsRepository;
import homework.service.BookingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class BookingsServiceImpl implements BookingsService {

    private final BookingsRepository repository;
    private final DtoMapper mapper;

    @Override
    public List<BookingFullDto> findAll() {
        return repository.findAll().stream()
                .map(bookings -> mapper.convertToDto(bookings, BookingFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookingFullDto findById(long id) {
        Bookings bookings = repository.findById(id);
        return mapper.convertToDto(bookings, BookingFullDto.class);
    }

    @Override
    public void save(BookingFullDto object) {
        Bookings bookings = mapper.convertToEntity(object, Bookings.class);
        repository.save(bookings);
    }

    @Override
    public void update(long id, BookingFullDto updateDTO) {
        Bookings bookings = mapper.convertToEntity(updateDTO, Bookings.class);
        repository.update(bookings);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public List<BookingFullDto> findBookingsInPeriod(LocalDate startDate, LocalDate endDate) {
        return repository.findBookingsInPeriod(startDate, endDate).stream()
                .map(bookings -> mapper.convertToDto(bookings, BookingFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingFullDto> findByUserAndStatus(Long userId, String status) {
        return repository.findByUserAndStatus(userId, status).stream()
                .map(bookings -> mapper.convertToDto(bookings, BookingFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookingFullDto> findExpiringBookings(int days) {
        return repository.findExpiringBookings(days).stream()
                .map(bookings -> mapper.convertToDto(bookings, BookingFullDto.class))
                .collect(Collectors.toList());
    }
}
