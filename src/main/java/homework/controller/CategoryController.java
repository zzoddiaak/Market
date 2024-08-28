package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.category.CategoryFullDto;
import homework.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService service;
    private final DtoMapperService mapperService;

    public CategoryController(CategoryService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public ResponseEntity<String> findAll() {
        try {
            List<CategoryFullDto> categories = service.findAll();
            String json = mapperService.convertToJson(categories);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") long id) {
        try {
            CategoryFullDto category = service.findById(id);
            String json = mapperService.convertToJson(category);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CategoryFullDto categoryFullDto) {
        service.save(categoryFullDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody String json) {
        try {
            CategoryFullDto dto = mapperService.convertFromJson(json, CategoryFullDto.class);
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
