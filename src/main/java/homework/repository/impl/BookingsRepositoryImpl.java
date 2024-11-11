package homework.repository.impl;

import homework.entity.Bookings;
import homework.entity.Bookings_;
import homework.repository.AbstractRepository;
import homework.repository.api.BookingsRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public class BookingsRepositoryImpl extends AbstractRepository<Long, Bookings> implements BookingsRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public BookingsRepositoryImpl() {
        super(Bookings.class);
    }

    @Override
    public List<Bookings> findByStatusJPQL(String status) {
        TypedQuery<Bookings> query = entityManager.createQuery(
                "SELECT b FROM Bookings b WHERE b.status = :status", Bookings.class);
        query.setParameter("status", status);

        return query.getResultList();
    }

    @Override
    public List<Bookings> findAllWithAssociationsEntityGraph() {
        EntityGraph<Bookings> graph = entityManager.createEntityGraph(Bookings.class);
        graph.addAttributeNodes("listings", "users");

        TypedQuery<Bookings> query = entityManager.createQuery("SELECT b FROM Bookings b", Bookings.class);
        query.setHint("jakarta.persistence.fetchgraph", graph);

        return query.getResultList();
    }

    // Поиск бронирований в определенном периоде
    @Override
    public List<Bookings> findBookingsInPeriod(LocalDate startDate, LocalDate endDate) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bookings> query = cb.createQuery(Bookings.class);
        Root<Bookings> booking = query.from(Bookings.class);

        query.select(booking)
                .where(cb.and(
                        cb.greaterThanOrEqualTo(booking.get(Bookings_.startDate), startDate),
                        cb.lessThanOrEqualTo(booking.get(Bookings_.endDate), endDate)
                ));

        return entityManager.createQuery(query).getResultList();
    }

    // Поиск бронирований по пользователю и статусу

    @Override
    public List<Bookings> findByUserAndStatus(Long userId, String status) {
        TypedQuery<Bookings> query = entityManager.createQuery(
                "SELECT b FROM Bookings b JOIN b.users u WHERE u.id = :userId AND b.status = :status",
                Bookings.class
        );
        query.setParameter("userId", userId);
        query.setParameter("status", status);

        return query.getResultList();
    }

    // Поиск бронирований, истекающих в ближайшие дни
    @Override
    public List<Bookings> findExpiringBookings(int days) {
        LocalDate now = LocalDate.now();
        LocalDate expiryDate = now.plusDays(days);

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Bookings> query = cb.createQuery(Bookings.class);
        Root<Bookings> booking = query.from(Bookings.class);

        query.select(booking)
                .where(cb.between(booking.get(Bookings_.endDate), now, expiryDate));

        return entityManager.createQuery(query).getResultList();
    }

    // Поиск бронирований с заданным количеством ассоциаций Listings
    @Override
    public List<Bookings> findByListingCount(int listingCount) {
        TypedQuery<Bookings> query = entityManager.createQuery(
                "SELECT b FROM Bookings b WHERE SIZE(b.listings) = :listingCount",
                Bookings.class
        );
        query.setParameter("listingCount", listingCount);

        return query.getResultList();
    }

    // Массовое обновление статуса бронирований
    @Override
    public int updateStatusForBookings(String currentStatus, String newStatus) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Bookings> update = cb.createCriteriaUpdate(Bookings.class);
        Root<Bookings> booking = update.from(Bookings.class);

        update.set(booking.get(Bookings_.status), newStatus)
                .where(cb.equal(booking.get(Bookings_.status), currentStatus));

        return entityManager.createQuery(update).executeUpdate();
    }
}