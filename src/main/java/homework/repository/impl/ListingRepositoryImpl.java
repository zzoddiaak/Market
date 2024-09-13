package homework.repository.impl;

import homework.entity.Listing;
import homework.entity.Listing_;
import homework.repository.AbstractRepository;
import homework.repository.api.ListingRepository;
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
public class ListingRepositoryImpl extends AbstractRepository<Long, Listing> implements ListingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public ListingRepositoryImpl() {
        super(Listing.class);
    }

    // JPQL запрос: Поиск по ID
    @Override
    public Listing findById(Long id) {
        TypedQuery<Listing> query = entityManager.createQuery(
                "SELECT l FROM Listing l WHERE l.id = :id", Listing.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    // JPQL запрос: Поиск всех элементов
    @Override
    public List<Listing> findAll() {
        TypedQuery<Listing> query = entityManager.createQuery(
                "SELECT l FROM Listing l", Listing.class);
        return query.getResultList();
    }

    // JPQL запрос: Поиск по типу объявления
    public List<Listing> findByListingTypeJPQL(String listingType) {
        TypedQuery<Listing> query = entityManager.createQuery(
                "SELECT l FROM Listing l WHERE l.listingType = :listingType", Listing.class);
        query.setParameter("listingType", listingType);
        return query.getResultList();
    }


    // Criteria API запрос: Поиск по цене с использованием метамодели
    public List<Listing> findByPriceCriteria(BigDecimal price) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Listing> query = cb.createQuery(Listing.class);
        Root<Listing> root = query.from(Listing.class);

        Predicate predicate = cb.equal(root.get(Listing_.price), price);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    // Обновление данных
    @Override
    public void update(Long id, Listing listing) {
        Listing existingListing = findById(id);
        if (existingListing != null) {
            existingListing.setTitle(listing.getTitle());
            existingListing.setDescription(listing.getDescription());
            existingListing.setPrice(listing.getPrice());
            existingListing.setNegotiable(listing.isNegotiable());
            existingListing.setListingType(listing.getListingType());
            existingListing.setItemType(listing.getItemType());
            existingListing.setAddress(listing.getAddress());
            existingListing.setRentalPrice(listing.getRentalPrice());
            existingListing.setCreatedAt(listing.getCreatedAt());
            existingListing.setUsers(listing.getUsers());
            existingListing.setCategories(listing.getCategories());
            entityManager.merge(existingListing);
        }
    }
}
