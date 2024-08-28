package homework.controller;

import homework.dto.DtoMapperService;
import homework.dto.transaction.TransactionFullDto;
import homework.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService service;
    private final DtoMapperService mapperService;

    public TransactionController(TransactionService service, DtoMapperService mapperService) {
        this.service = service;
        this.mapperService = mapperService;
    }

    @GetMapping
    public ResponseEntity<String> findAll() {
        try {
            List<TransactionFullDto> transactions = service.findAll();
            String json = mapperService.convertToJson(transactions);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> findById(@PathVariable("id") long id) {
        try {
            TransactionFullDto transaction = service.findById(id);
            String json = mapperService.convertToJson(transaction);
            return ResponseEntity.ok(json);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error occurred");
        }
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody TransactionFullDto transactionFullDto) {
        service.save(transactionFullDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") long id, @RequestBody String json) {
        try {
            TransactionFullDto dto = mapperService.convertFromJson(json, TransactionFullDto.class);
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
