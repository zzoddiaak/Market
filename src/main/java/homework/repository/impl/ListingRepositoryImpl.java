package homework.repository.impl;

import homework.entity.Listing;
import homework.entity.Listing_;
import homework.repository.AbstractRepository;
import homework.repository.api.ListingRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ListingRepositoryImpl extends AbstractRepository<Long, Listing> implements ListingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ListingRepositoryImpl() {
        super(Listing.class);
    }

    // Criteria API
    public List<Listing> findAllWithAssociationsCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Listing> query = cb.createQuery(Listing.class);
        Root<Listing> root = query.from(Listing.class);

        root.fetch(Listing_.users, JoinType.LEFT);
        root.fetch(Listing_.categories, JoinType.LEFT);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    // JPQL
    public List<Listing> findAllWithAssociationsJPQL() {
        String jpql = "SELECT l FROM Listing l " +
                "LEFT JOIN FETCH l.users " +
                "LEFT JOIN FETCH l.categories";
        TypedQuery<Listing> query = entityManager.createQuery(jpql, Listing.class);

        return query.getResultList();
    }

    // EntityGraph
    public List<Listing> findAllWithAssociationsEntityGraph() {
        EntityGraph<Listing> graph = entityManager.createEntityGraph(Listing.class);

        graph.addAttributeNodes("users");
        graph.addAttributeNodes("categories");

        TypedQuery<Listing> query = entityManager.createQuery("SELECT l FROM Listing l", Listing.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getResultList();
    }



    // Поиск по цене с использованием
    public List<Listing> findByPriceCriteria(BigDecimal price) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Listing> query = cb.createQuery(Listing.class);
        Root<Listing> root = query.from(Listing.class);

        Predicate predicate = cb.equal(root.get(Listing_.price), price);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }


}
