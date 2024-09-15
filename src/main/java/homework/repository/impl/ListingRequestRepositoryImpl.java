package homework.repository.impl;

import homework.entity.ListingRequest;
import homework.entity.ListingRequest_;
import homework.repository.AbstractRepository;
import homework.repository.api.ListingRequestRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ListingRequestRepositoryImpl extends AbstractRepository<Long, ListingRequest> implements ListingRequestRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ListingRequestRepositoryImpl() {
        super(ListingRequest.class);
    }

    // Criteria API
    public List<ListingRequest> findAllWithAssociationsCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ListingRequest> query = cb.createQuery(ListingRequest.class);
        Root<ListingRequest> root = query.from(ListingRequest.class);

        root.fetch(ListingRequest_.listing, JoinType.LEFT);
        root.fetch(ListingRequest_.requester, JoinType.LEFT);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    // JPQL
    public List<ListingRequest> findAllWithAssociationsJPQL() {
        String jpql = "SELECT lr FROM ListingRequest lr " +
                "LEFT JOIN FETCH lr.listing " +
                "LEFT JOIN FETCH lr.requester";
        TypedQuery<ListingRequest> query = entityManager.createQuery(jpql, ListingRequest.class);
        return query.getResultList();
    }

    // EntityGraph
    public List<ListingRequest> findAllWithAssociationsEntityGraph() {
        EntityGraph<ListingRequest> graph = entityManager.createEntityGraph(ListingRequest.class);

        graph.addAttributeNodes("listing");
        graph.addAttributeNodes("requester");

        TypedQuery<ListingRequest> query = entityManager.createQuery("SELECT lr FROM ListingRequest lr", ListingRequest.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getResultList();
    }


    // Поиск по предложенной цене
    public List<ListingRequest> findByOfferedPriceCriteria(BigDecimal offeredPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ListingRequest> query = cb.createQuery(ListingRequest.class);
        Root<ListingRequest> root = query.from(ListingRequest.class);

        Predicate predicate = cb.equal(root.get(ListingRequest_.offeredPrice), offeredPrice);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void update(Long id, ListingRequest listingRequest) {
        ListingRequest existingListingRequest = findById(id);
        if (existingListingRequest != null) {
            existingListingRequest.setOfferedPrice(listingRequest.getOfferedPrice());
            existingListingRequest.setStatus(listingRequest.getStatus());
            existingListingRequest.setCreatedAt(listingRequest.getCreatedAt());
            existingListingRequest.setListing(listingRequest.getListing());
            existingListingRequest.setRequester(listingRequest.getRequester());
            entityManager.merge(existingListingRequest);
        }
    }
}
