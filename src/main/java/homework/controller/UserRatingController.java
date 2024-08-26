package homework.controller;

import homework.dto.userRating.UserRatingFullDto;
import homework.service.UserRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class UserRatingController {
    private final UserRatingService service;

    @GetMapping
    public ResponseEntity<List<UserRatingFullDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRatingFullDto> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserRatingFullDto userRatingFullDto) {
        service.save(userRatingFullDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody UserRatingFullDto userRatingFullDto) {
        service.update(id, userRatingFullDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
