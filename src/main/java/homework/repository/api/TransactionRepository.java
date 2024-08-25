package homework.repository.api;

import homework.entity.Transaction;

import java.util.List;

public interface TransactionRepository {
    Transaction findById(Long id);
    List<Transaction> findAll();
    void save(Transaction transaction);
    void deleteById(Long id);
}
