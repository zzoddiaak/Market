package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.role.RoleFullDto;
import homework.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private final RoleService service;
    private final DtoMapperService mapperService;

    public RoleController(RoleService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public ResponseEntity<String> findAll() {
        try {
            List<RoleFullDto> roles = service.findAll();
            String json = mapperService.convertToJson(roles);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") long id) {
        try {
            RoleFullDto role = service.findById(id);
            String json = mapperService.convertToJson(role);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody RoleFullDto roleFullDto) {
        service.save(roleFullDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody String json) {
        try {
            RoleFullDto dto = mapperService.convertFromJson(json, RoleFullDto.class);
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
