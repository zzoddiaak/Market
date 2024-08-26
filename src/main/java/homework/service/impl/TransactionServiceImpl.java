package homework.service.impl;

import homework.dto.DtoMapperService;
import homework.dto.transaction.TransactionFullDto;
import homework.entity.Transaction;
import homework.repository.api.TransactionRepository;
import homework.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {
    private final TransactionRepository repository;
    private final DtoMapperService mapperService;

    @Override
    public List<TransactionFullDto> findAll() {
        return repository.findAll().stream()
                .map(transaction -> mapperService.convertToDto(transaction, TransactionFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionFullDto findById(long id) {
        Transaction transaction = repository.findById(id);
        return mapperService.convertToDto(transaction, TransactionFullDto.class);
    }

    @Override
    public void save(TransactionFullDto object) {
        Transaction transaction = mapperService.convertToEntity(object, Transaction.class);
        repository.save(transaction);
    }

    @Override
    public void update(long id, TransactionFullDto updateDTO) {
        Transaction transaction = mapperService.convertToEntity(updateDTO, Transaction.class);
        repository.update(id, transaction);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
