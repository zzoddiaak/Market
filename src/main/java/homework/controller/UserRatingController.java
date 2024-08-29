package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.userRating.UserRatingFullDto;
import homework.service.UserRatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userRatings")
public class UserRatingController {

    private final UserRatingService service;
    private final DtoMapperService mapperService;

    public UserRatingController(UserRatingService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public String findAll() {
        List<UserRatingFullDto> dtos = service.findAll();
        return mapperService.convertToJson(dtos);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        UserRatingFullDto dto = service.findById(id);
        return mapperService.convertToJson(dto);
    }

    @PostMapping
    public String save(@RequestBody UserRatingFullDto userRatingFullDto) {
        service.save(userRatingFullDto);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        UserRatingFullDto dto = mapperService.convertFromJson(json, UserRatingFullDto.class);
        service.update(id, dto);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
