package homework.service.impl;

import homework.dto.DtoMapperService;
import homework.dto.booking.BookingFullDto;
import homework.entity.Bookings;
import homework.repository.api.BookingsRepository;
import homework.service.BookingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingsServiceImpl implements BookingsService {
    private final BookingsRepository repository;
    private final DtoMapperService mapperService;

    @Override
    public List<BookingFullDto> findAll() {
        return repository.findAll().stream()
                .map(bookings -> mapperService.convertToDto(bookings, BookingFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public BookingFullDto findById(long id) {
        Bookings bookings = repository.findById(id);
        return mapperService.convertToDto(bookings, BookingFullDto.class);
    }

    @Override
    public void save(BookingFullDto object) {
        Bookings bookings = mapperService.convertToEntity(object, Bookings.class);
        repository.save(bookings);
    }

    @Override
    public void update(long id, BookingFullDto updateDTO) {
        Bookings bookings = mapperService.convertToEntity(updateDTO, Bookings.class);
        repository.update(id, bookings);
    }


    @Override
    public void deleteById(long id) {
        repository.deleteById(id);

    }
}
