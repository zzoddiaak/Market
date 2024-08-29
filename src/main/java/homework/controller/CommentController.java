package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.comment.CommentFullDto;
import homework.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {

    private final CommentService service;
    private final DtoMapperService mapperService;

    public CommentController(CommentService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public String findAll() {
        List<CommentFullDto> comments = service.findAll();
        return mapperService.convertToJson(comments);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        CommentFullDto comment = service.findById(id);
        return mapperService.convertToJson(comment);
    }

    @PostMapping
    public String save(@RequestBody CommentFullDto commentFullDto) {
        service.save(commentFullDto);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        CommentFullDto dto = mapperService.convertFromJson(json, CommentFullDto.class);
        service.update(id, dto);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
