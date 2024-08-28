package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.listingRequest.ListingRequestFullDto;
import homework.service.ListingRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/listingRequests")
public class ListingRequestController {
    private final ListingRequestService service;
    private final DtoMapperService mapperService;

    public ListingRequestController(ListingRequestService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public ResponseEntity<String> findAll() {
        try {
            List<ListingRequestFullDto> listingRequests = service.findAll();
            String json = mapperService.convertToJson(listingRequests);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") long id) {
        try {
            ListingRequestFullDto listingRequest = service.findById(id);
            String json = mapperService.convertToJson(listingRequest);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ListingRequestFullDto listingRequestFullDto) {
        service.save(listingRequestFullDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody String json) {
        try {
            ListingRequestFullDto dto = mapperService.convertFromJson(json, ListingRequestFullDto.class);
            service.update(id, dto);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
