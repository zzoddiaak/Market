package homework.controller;

import homework.dto.JsonMapper;
import homework.dto.userRating.UserRatingFullDto;
import homework.service.UserRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/userRatings")
public class UserRatingController {

    private final UserRatingService service;
    private final JsonMapper mapper;



    @GetMapping
    public String findAll() {
        List<UserRatingFullDto> dtos = service.findAll();
        return mapper.convertToJson(dtos);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        UserRatingFullDto dto = service.findById(id);
        return mapper.convertToJson(dto);
    }

    @PostMapping
    public String save(@RequestBody UserRatingFullDto userRatingFullDto) {
        service.save(userRatingFullDto);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        UserRatingFullDto dto = mapper.convertFromJson(json, UserRatingFullDto.class);
        service.update(id, dto);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
