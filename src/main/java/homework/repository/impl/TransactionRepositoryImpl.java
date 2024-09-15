package homework.repository.impl;

import homework.entity.Transaction;
import homework.entity.Transaction_;
import homework.repository.AbstractRepository;
import homework.repository.api.TransactionRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class TransactionRepositoryImpl extends AbstractRepository<Long, Transaction> implements TransactionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public TransactionRepositoryImpl() {
        super(Transaction.class);
    }

    // Поиск по ID
    @Override
    public Transaction findById(Long id) {
        TypedQuery<Transaction> query = entityManager.createQuery(
                "SELECT t FROM Transaction t WHERE t.id = :id", Transaction.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    // Поиск всех транзакций
    @Override
    public List<Transaction> findAll() {
        TypedQuery<Transaction> query = entityManager.createQuery(
                "SELECT t FROM Transaction t", Transaction.class);
        return query.getResultList();
    }

    // Поиск по дате завершения
    public List<Transaction> findByCompletedAtCriteria(LocalDate completedAt) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transaction> query = cb.createQuery(Transaction.class);
        Root<Transaction> root = query.from(Transaction.class);

        Predicate predicate = cb.equal(root.get(Transaction_.completedAt), completedAt);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void update(Long id, Transaction transaction) {
        Transaction existingTransaction = findById(id);
        if (existingTransaction != null) {
            existingTransaction.setCompletedAt(transaction.getCompletedAt());
            existingTransaction.setRequest(transaction.getRequest());
            entityManager.merge(existingTransaction);
        }
    }
}
