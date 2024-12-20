package homework.service.impl;

import homework.dto.DtoMapper;
import homework.dto.transaction.TransactionFullDto;
import homework.entity.Transaction;
import homework.repository.api.TransactionRepository;
import homework.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final DtoMapper mapper;

    @Override
    public List<TransactionFullDto> findAll() {

        return repository.findAll().stream()
                .map(transaction -> mapper.convertToDto(transaction, TransactionFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public TransactionFullDto findById(long id) {
        Transaction transaction = repository.findById(id);

        return mapper.convertToDto(transaction, TransactionFullDto.class);
    }

    @Override
    public void save(TransactionFullDto object) {
        Transaction transaction = mapper.convertToEntity(object, Transaction.class);
        repository.save(transaction);
    }

    @Override
    public void update(long id, TransactionFullDto updateDTO) {
        Transaction transaction  = mapper.convertToEntity(updateDTO, Transaction.class);
        repository.update(transaction);
    }


    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
