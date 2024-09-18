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
        graph.addAttributeNodes("listings");
        graph.addAttributeNodes("users");

        TypedQuery<Bookings> query = entityManager.createQuery("SELECT b FROM Bookings b", Bookings.class);
        query.setHint("jakarta.persistence.fetchgraph", graph);

        return query.getResultList();
    }
}

