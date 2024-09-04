package homework.controller;

import homework.dto.JsonMapper;
import homework.dto.listingRequest.ListingRequestFullDto;
import homework.service.ListingRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/listingRequests")
public class ListingRequestController {

    private final ListingRequestService service;
    private final JsonMapper mapper;



    @GetMapping
    public String findAll() {
        List<ListingRequestFullDto> listingRequests = service.findAll();

        return mapper.convertToJson(listingRequests);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        ListingRequestFullDto listingRequest = service.findById(id);

        return mapper.convertToJson(listingRequest);
    }

    @PostMapping
    public String save(@RequestBody ListingRequestFullDto listingRequestFullDto) {
        service.save(listingRequestFullDto);

        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        ListingRequestFullDto dto = mapper.convertFromJson(json, ListingRequestFullDto.class);
        service.update(id, dto);

        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);

        return "Deleted successfully";
    }
}
