package homework.repository.impl;

import homework.entity.FavoriteItem;
import homework.entity.FavoriteItem_;
import homework.repository.AbstractRepository;
import homework.repository.api.FavoriteItemRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteItemRepositoryImpl extends AbstractRepository<Long, FavoriteItem> implements FavoriteItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public FavoriteItemRepositoryImpl() {
        super(FavoriteItem.class);
    }



    // Criteria API
    public List<FavoriteItem> findAllWithAssociationsCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FavoriteItem> query = cb.createQuery(FavoriteItem.class);
        Root<FavoriteItem> root = query.from(FavoriteItem.class);

        root.fetch(FavoriteItem_.user, JoinType.LEFT);
        root.fetch(FavoriteItem_.listing, JoinType.LEFT);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    // JPQL
    public List<FavoriteItem> findAllWithAssociationsJPQL() {
        String jpql = "SELECT fi FROM FavoriteItem fi " +
                "LEFT JOIN FETCH fi.user " +
                "LEFT JOIN FETCH fi.listing";
        TypedQuery<FavoriteItem> query = entityManager.createQuery(jpql, FavoriteItem.class);
        return query.getResultList();
    }

    // EntityGraph
    public List<FavoriteItem> findAllWithAssociationsEntityGraph() {
        EntityGraph<FavoriteItem> graph = entityManager.createEntityGraph(FavoriteItem.class);

        graph.addAttributeNodes("user");
        graph.addAttributeNodes("listing");

        TypedQuery<FavoriteItem> query = entityManager.createQuery("SELECT fi FROM FavoriteItem fi", FavoriteItem.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getResultList();
    }


    public void update(Long id, FavoriteItem favoriteItem) {
        FavoriteItem existingFavoriteItem = findById(id);
        if (existingFavoriteItem != null) {
            existingFavoriteItem.setUser(favoriteItem.getUser());
            existingFavoriteItem.setListing(favoriteItem.getListing());
            entityManager.merge(existingFavoriteItem);
        }
    }
}
