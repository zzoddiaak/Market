package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.listingRequest.ListingRequestFullDto;
import homework.service.ListingRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/listingRequests")
public class ListingRequestController {

    private final ListingRequestService service;
    private final DtoMapperService mapperService;

    public ListingRequestController(ListingRequestService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public String findAll() {
        List<ListingRequestFullDto> listingRequests = service.findAll();
        return mapperService.convertToJson(listingRequests);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        ListingRequestFullDto listingRequest = service.findById(id);
        return mapperService.convertToJson(listingRequest);
    }

    @PostMapping
    public String save(@RequestBody ListingRequestFullDto listingRequestFullDto) {
        service.save(listingRequestFullDto);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        ListingRequestFullDto dto = mapperService.convertFromJson(json, ListingRequestFullDto.class);
        service.update(id, dto);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
