package homework.repository.impl;

import homework.entity.Bookings;
import homework.entity.Bookings_;
import homework.repository.AbstractRepository;
import homework.repository.api.BookingsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BookingsRepositoryImpl extends AbstractRepository<Long, Bookings> implements BookingsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public BookingsRepositoryImpl() {
        super(Bookings.class);
    }

    // Поиск по статусу
    public List<Bookings> findByStatusJPQL(String status) {
        TypedQuery<Bookings> query = entityManager.createQuery(
                "SELECT b FROM Bookings b WHERE b.status = :status", Bookings.class);
        query.setParameter("status", status);

        return query.getResultList();
    }

    // Поиск по дате
    public List<Bookings> findByDateCriteria(LocalDate startDate, LocalDate endDate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bookings> query = cb.createQuery(Bookings.class);
        Root<Bookings> root = query.from(Bookings.class);

        List<Predicate> predicates = new ArrayList<>();
        if (startDate != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get(Bookings_.startDate), startDate));
        }
        if (endDate != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get(Bookings_.endDate), endDate));
        }

        query.select(root).where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(query).getResultList();
    }

    public void update(Long id, Bookings bookings) {
        Bookings existingBooking = findById(id);
        if (existingBooking != null) {
            existingBooking.setStatus(bookings.getStatus());
            existingBooking.setStartDate(bookings.getStartDate());
            existingBooking.setEndDate(bookings.getEndDate());
            entityManager.merge(existingBooking);
        }
    }
}
