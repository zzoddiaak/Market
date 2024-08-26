package homework.service;

import homework.dto.transaction.TransactionFullDto;
import java.util.List;

public interface TransactionService {
    List<TransactionFullDto> findAll();
    TransactionFullDto findById(long id);
    void save(TransactionFullDto object);
    void update(long id,TransactionFullDto  updateDTO);
    void deleteById(long id);
}
