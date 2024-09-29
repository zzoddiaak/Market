package homework.controller;

import homework.dto.JsonMapper;
import homework.dto.listing.ListingFullDto;
import homework.service.ListingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/listings")
@RequiredArgsConstructor
public class ListingController {

    private final ListingService service;
    private final JsonMapper mapper;

    @GetMapping
    public String findAll() {
        List<ListingFullDto> listings = service.findAll();

        return mapper.convertToJson(listings);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        ListingFullDto listing = service.findById(id);

        return mapper.convertToJson(listing);
    }

    @PostMapping
    public String save(@RequestBody ListingFullDto listingFullDto) {
        service.save(listingFullDto);

        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        ListingFullDto dto = mapper.convertFromJson(json, ListingFullDto.class);
        service.update(id, dto);

        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);

        return "Deleted successfully";
    }
}
