package homework.controller;

import homework.dto.JsonMapper;
import homework.dto.favoriteItem.FavoriteItemFullDto;
import homework.service.FavoriteItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/favoriteItems")
public class FavoriteItemController {

    private final FavoriteItemService service;
    private final JsonMapper mapperService;


    @GetMapping
    public String findAll() {
        List<FavoriteItemFullDto> favoriteItems = service.findAll();
        return mapperService.convertToJson(favoriteItems);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        FavoriteItemFullDto favoriteItem = service.findById(id);
        return mapperService.convertToJson(favoriteItem);
    }

    @PostMapping
    public String save(@RequestBody FavoriteItemFullDto favoriteItemFullDto) {
        service.save(favoriteItemFullDto);
        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        FavoriteItemFullDto dto = mapperService.convertFromJson(json, FavoriteItemFullDto.class);
        service.update(id, dto);
        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
        return "Deleted successfully";
    }
}
