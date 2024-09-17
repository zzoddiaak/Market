package homework.repository.impl;

import homework.entity.Transaction;
import homework.entity.Transaction_;
import homework.repository.AbstractRepository;
import homework.repository.api.TransactionRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
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

    @Override
    public List<Transaction> findAllWithAssociationsCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transaction> query = cb.createQuery(Transaction.class);
        Root<Transaction> root = query.from(Transaction.class);

        root.fetch(Transaction_.request, JoinType.LEFT);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<Transaction> findAllWithAssociationsJPQL() {
        String jpql = "SELECT t FROM Transaction t " +
                "LEFT JOIN FETCH t.request";
        TypedQuery<Transaction> query = entityManager.createQuery(jpql, Transaction.class);

        return query.getResultList();
    }

    @Override
    public List<Transaction> findAllWithAssociationsEntityGraph() {
        EntityGraph<Transaction> graph = entityManager.createEntityGraph(Transaction.class);

        graph.addAttributeNodes("request");

        TypedQuery<Transaction> query = entityManager.createQuery("SELECT t FROM Transaction t", Transaction.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getResultList();
    }


    @Override
    public List<Transaction> findByCompletedAtCriteria(LocalDate completedAt) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Transaction> query = cb.createQuery(Transaction.class);
        Root<Transaction> root = query.from(Transaction.class);

        Predicate predicate = cb.equal(root.get(Transaction_.completedAt), completedAt);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }


}
