package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.category.CategoryFullDto;
import homework.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;
    private final DtoMapperService mapperService;

    public CategoryController(CategoryService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public String findAll() {
        List<CategoryFullDto> dtos = service.findAll();
        return mapperService.convertToJson(dtos);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        CategoryFullDto dto = service.findById(id);
        return mapperService.convertToJson(dto);
    }

    @PostMapping
    public String save(@RequestBody CategoryFullDto categoryFullDto) {
        service.save(categoryFullDto);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        CategoryFullDto dto = mapperService.convertFromJson(json, CategoryFullDto.class);
        service.update(id, dto);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
