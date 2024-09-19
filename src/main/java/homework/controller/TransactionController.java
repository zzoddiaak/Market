package homework.controller;

import homework.dto.JsonMapper;
import homework.dto.transaction.TransactionFullDto;
import homework.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService service;
    private final JsonMapper mapperService;

    @GetMapping
    public String findAll() {
        List<TransactionFullDto> dtos = service.findAll();

        return mapperService.convertToJson(dtos);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable("id") long id) {
        TransactionFullDto dto = service.findById(id);

        return mapperService.convertToJson(dto);
    }

    @PostMapping
    public String save(@RequestBody TransactionFullDto transactionFullDto) {
        service.save(transactionFullDto);

        return "Saved successfully";
    }

    @PutMapping("/{id}")
    public String update(@PathVariable("id") long id, @RequestBody String json) {
        TransactionFullDto dto = mapperService.convertFromJson(json, TransactionFullDto.class);
        service.update(id, dto);

        return "Updated successfully";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable("id") long id) {
        service.deleteById(id);

        return "Deleted successfully";
    }
}
