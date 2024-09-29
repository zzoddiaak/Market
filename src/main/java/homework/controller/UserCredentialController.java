package homework.controller;

import homework.dto.JsonMapper;
import homework.dto.userCredential.UserCredentialFullDto;
import homework.service.UserCredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user_credentials")
@RequiredArgsConstructor
public class UserCredentialController {

    private final UserCredentialService service;
    private final JsonMapper mapper;

    @GetMapping
    public String findAll() {
        List<UserCredentialFullDto> dtos = service.findAll();

        return mapper.convertToJson(dtos);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        UserCredentialFullDto dto = service.findById(id);

        return mapper.convertToJson(dto);
    }

    @PostMapping
    public String save(@RequestBody UserCredentialFullDto userCredentialFullDto) {
        service.save(userCredentialFullDto);

        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        UserCredentialFullDto dto = mapper.convertFromJson(json, UserCredentialFullDto.class);
        service.update(id, dto);

        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);

        return "Deleted successfully";
    }
}
