package homework.repository.impl;

import homework.entity.ListingRequest;
import homework.entity.ListingRequest_;
import homework.repository.AbstractRepository;
import homework.repository.api.ListingRequestRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
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

    // JPQL запрос: Поиск по ID
    @Override
    public ListingRequest findById(Long id) {
        TypedQuery<ListingRequest> query = entityManager.createQuery(
                "SELECT lr FROM ListingRequest lr WHERE lr.id = :id", ListingRequest.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    // JPQL запрос: Поиск всех элементов
    @Override
    public List<ListingRequest> findAll() {
        TypedQuery<ListingRequest> query = entityManager.createQuery(
                "SELECT lr FROM ListingRequest lr", ListingRequest.class);
        return query.getResultList();
    }

    // JPQL запрос: Поиск по статусу
    public List<ListingRequest> findByStatusJPQL(String status) {
        TypedQuery<ListingRequest> query = entityManager.createQuery(
                "SELECT lr FROM ListingRequest lr WHERE lr.status = :status", ListingRequest.class);
        query.setParameter("status", status);
        return query.getResultList();
    }

    // Criteria API запрос: Поиск по предложенной цене
    public List<ListingRequest> findByOfferedPriceCriteria(BigDecimal offeredPrice) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ListingRequest> query = cb.createQuery(ListingRequest.class);
        Root<ListingRequest> root = query.from(ListingRequest.class);

        Predicate predicate = cb.equal(root.get(ListingRequest_.offeredPrice), offeredPrice);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }
    // Обновление данных
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
