package homework.repository.api;

import homework.entity.Transaction;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository {
    Transaction findById(Long id);
    List<Transaction> findAll();
    void save(Transaction transaction);
    void deleteById(Long id);
    void update(Transaction transaction);
    List<Transaction> findByCompletedAtCriteria(LocalDate completedAt);
    List<Transaction> findAllWithAssociationsEntityGraph();
    List<Transaction> findAllWithAssociationsJPQL();
    List<Transaction> findAllWithAssociationsCriteria();

}
