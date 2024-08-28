package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.userRating.UserRatingFullDto;
import homework.service.UserRatingService;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/userRatings")
public class UserRatingController {
    private final UserRatingService service;
    private final DtoMapperService mapperService;

    public UserRatingController(UserRatingService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public ResponseEntity<String> findAll() {
        try {
            List<UserRatingFullDto> userRatings = service.findAll();
            String json = mapperService.convertToJson(userRatings);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") long id) {
        try {
            UserRatingFullDto userRating = service.findById(id);
            String json = mapperService.convertToJson(userRating);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody UserRatingFullDto userRatingFullDto) {
        service.save(userRatingFullDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody String json) {
        try {
            UserRatingFullDto dto = mapperService.convertFromJson(json, UserRatingFullDto.class);
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
