package homework.controller;

import homework.dto.listingRequest.ListingRequestFullDto;
import homework.entity.ListingRequest;
import homework.service.ListingRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;;import java.util.List;

@Controller
@RequiredArgsConstructor
public class ListingRequestController {
    private final ListingRequestService service;

    @GetMapping
    public ResponseEntity<List<ListingRequestFullDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ListingRequestFullDto> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody ListingRequestFullDto listingRequestFullDto) {
        service.save(listingRequestFullDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody ListingRequestFullDto listingRequestFullDto) {
        service.update(id, listingRequestFullDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
