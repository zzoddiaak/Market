package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.listing.ListingFullDto;
import homework.service.ListingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listings")
public class ListingController {

    private final ListingService service;
    private final DtoMapperService mapperService;

    public ListingController(ListingService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public String findAll() {
        List<ListingFullDto> listings = service.findAll();
        return mapperService.convertToJson(listings);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        ListingFullDto listing = service.findById(id);
        return mapperService.convertToJson(listing);
    }

    @PostMapping
    public String save(@RequestBody ListingFullDto listingFullDto) {
        service.save(listingFullDto);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        ListingFullDto dto = mapperService.convertFromJson(json, ListingFullDto.class);
        service.update(id, dto);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
