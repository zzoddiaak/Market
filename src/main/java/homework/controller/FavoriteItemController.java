package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.favoriteItem.FavoriteItemFullDto;
import homework.service.FavoriteItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/favoriteItems")
public class FavoriteItemController {
    private final FavoriteItemService service;
    private final DtoMapperService mapperService;

    public FavoriteItemController(FavoriteItemService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public ResponseEntity<String> findAll() {
        try {
            List<FavoriteItemFullDto> favoriteItems = service.findAll();
            String json = mapperService.convertToJson(favoriteItems);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") long id) {
        try {
            FavoriteItemFullDto favoriteItem = service.findById(id);
            String json = mapperService.convertToJson(favoriteItem);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody FavoriteItemFullDto favoriteItemFullDto) {
        service.save(favoriteItemFullDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody String json) {
        try {
            FavoriteItemFullDto dto = mapperService.convertFromJson(json, FavoriteItemFullDto.class);
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
