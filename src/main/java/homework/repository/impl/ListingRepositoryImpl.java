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

    @Override
    public List<Listing> findAllWithAssociationsCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Listing> query = cb.createQuery(Listing.class);
        Root<Listing> root = query.from(Listing.class);

        root.fetch(Listing_.users, JoinType.LEFT);
        query.select(root);

        List<Listing> listings = entityManager.createQuery(query).getResultList();

        for (Listing listing : listings) {
            listing.getCategories().size();
        }

        return listings;
    }

    @Override
    public List<Listing> findAllWithAssociationsJPQL() {
        String jpqlUsers = "SELECT l FROM Listing l LEFT JOIN FETCH l.users";
        TypedQuery<Listing> queryUsers = entityManager.createQuery(jpqlUsers, Listing.class);
        List<Listing> listings = queryUsers.getResultList();

        String jpqlCategories = "SELECT l FROM Listing l LEFT JOIN FETCH l.categories WHERE l IN :listings";
        TypedQuery<Listing> queryCategories = entityManager.createQuery(jpqlCategories, Listing.class);
        queryCategories.setParameter("listings", listings);

        return queryCategories.getResultList();
    }

    @Override
    public List<Listing> findAllWithAssociationsEntityGraph() {
        EntityGraph<Listing> graph = entityManager.createEntityGraph(Listing.class);
        graph.addAttributeNodes("users"); // Fetch users

        TypedQuery<Listing> query = entityManager.createQuery("SELECT l FROM Listing l", Listing.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        List<Listing> listings = query.getResultList();

        for (Listing listing : listings) {
            listing.getCategories().size();
        }

        return listings;
    }

    @Override
    public List<Listing> findByPriceCriteria(BigDecimal price) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Listing> query = cb.createQuery(Listing.class);
        Root<Listing> root = query.from(Listing.class);

        Predicate predicate = cb.equal(root.get(Listing_.price), price);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }
}
