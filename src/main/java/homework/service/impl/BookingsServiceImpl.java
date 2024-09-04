package homework.service.impl;

import homework.transaction.Transaction;
import org.springframework.stereotype.Service;
import homework.dto.DtoMapper;
import homework.dto.booking.BookingFullDto;
import homework.entity.Bookings;
import homework.repository.api.BookingsRepository;
import homework.service.BookingsService;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
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
    @Transaction
    public void save(BookingFullDto object) {
        Bookings bookings = mapper.convertToEntity(object, Bookings.class);
        repository.save(bookings);
    }

    @Override
    @Transaction
    public void update(long id, BookingFullDto updateDTO) {
        Bookings bookings = mapper.convertToEntity(updateDTO, Bookings.class);
        repository.update(id, bookings);
    }

    @Override
    @Transaction
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    // Пример транзакции с несколькими операциями
    @Transaction
    public void exampleTransactionalMethod(long bookingId, BookingFullDto newBooking) {
        update(bookingId, newBooking);

        save(newBooking);

    }
}
