package homework.controller;

import homework.dto.JsonMapper;
import homework.dto.role.RoleFullDto;
import homework.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService service;
    private final JsonMapper mapperService;

    @GetMapping
    public String findAll() {
        List<RoleFullDto> dtos = service.findAll();

        return mapperService.convertToJson(dtos);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        RoleFullDto dto = service.findById(id);

        return mapperService.convertToJson(dto);
    }

    @PostMapping
    public String save(@RequestBody RoleFullDto roleFullDto) {
        service.save(roleFullDto);

        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        RoleFullDto dto = mapperService.convertFromJson(json, RoleFullDto.class);
        service.update(id, dto);

        return "Updated successfully";
    }
    @GetMapping("/name/{roleName}")
    public String findByRoleName(@PathVariable("roleName") String roleName) {
        RoleFullDto dto = service.findByRoleName(roleName);
        return mapperService.convertToJson(dto);
    }


    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);

        return "Deleted successfully";
    }
}
