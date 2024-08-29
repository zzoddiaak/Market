package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.booking.BookingFullDto;
import homework.service.BookingsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingsController {

    private final BookingsService service;
    private final DtoMapperService mapperService;

    public BookingsController(BookingsService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public String findAll() {
        List<BookingFullDto> bookings = service.findAll();
        return mapperService.convertToJson(bookings);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        BookingFullDto booking = service.findById(id);
        return mapperService.convertToJson(booking);
    }

    @PostMapping
    public String save(@RequestBody BookingFullDto bookingFullDto) {
        service.save(bookingFullDto);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        BookingFullDto dto = mapperService.convertFromJson(json, BookingFullDto.class);
        service.update(id, dto);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
