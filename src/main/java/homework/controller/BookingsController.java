package homework.controller;

import homework.dto.JsonMapper;
import homework.dto.booking.BookingFullDto;
import homework.service.BookingsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bookings")
@RequiredArgsConstructor
public class BookingsController {

    private final BookingsService service;
    private final JsonMapper mapper;

    @GetMapping
    public String findAll() {
        List<BookingFullDto> bookings = service.findAll();
        return mapper.convertToJson(bookings);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        BookingFullDto booking = service.findById(id);
        return mapper.convertToJson(booking);
    }

    @PostMapping
    public String save(@RequestBody BookingFullDto bookingFullDto) {
        service.save(bookingFullDto);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        BookingFullDto dto = mapper.convertFromJson(json, BookingFullDto.class);
        service.update(id, dto);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }

    @GetMapping("/period")
    public String findBookingsInPeriod(@RequestParam("startDate") String startDate,
                                       @RequestParam("endDate") String endDate) {
        LocalDate start = LocalDate.parse(startDate);
        LocalDate end = LocalDate.parse(endDate);
        List<BookingFullDto> bookings = service.findBookingsInPeriod(start, end);
        return mapper.convertToJson(bookings);
    }

    @GetMapping("/user-status")
    public String findByUserAndStatus(@RequestParam("userId") Long userId,
                                      @RequestParam("status") String status) {
        List<BookingFullDto> bookings = service.findByUserAndStatus(userId, status);
        return mapper.convertToJson(bookings);
    }

    @GetMapping("/expiring")
    public String findExpiringBookings(@RequestParam("days") int days) {
        List<BookingFullDto> bookings = service.findExpiringBookings(days);
        return mapper.convertToJson(bookings);
    }
}
