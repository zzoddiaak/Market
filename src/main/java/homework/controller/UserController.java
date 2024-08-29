package homework.controller;

import homework.dto.JsonMapper;
import homework.dto.user.UserFullDto;
import homework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;
    private final JsonMapper mapperService;


    @GetMapping
    public String findAll() {
        List<UserFullDto> dtos = service.findAll();
        return mapperService.convertToJson(dtos);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        UserFullDto dto = service.findById(id);
        return mapperService.convertToJson(dto);
    }

    @PostMapping
    public String save(@RequestBody UserFullDto userFullDto) {
        service.save(userFullDto);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        UserFullDto dto = mapperService.convertFromJson(json, UserFullDto.class);
        service.update(id, dto);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
