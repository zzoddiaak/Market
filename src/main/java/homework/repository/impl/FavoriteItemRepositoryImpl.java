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

    @Override
    public List<FavoriteItem> findAllWithAssociationsCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FavoriteItem> query = cb.createQuery(FavoriteItem.class);
        Root<FavoriteItem> root = query.from(FavoriteItem.class);

        root.fetch("user", JoinType.LEFT);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<FavoriteItem> findAllWithAssociationsJPQL() {
        String jpql = "SELECT fi FROM FavoriteItem fi " +
                "LEFT JOIN fi.user u " +
                "LEFT JOIN fi.listing l";
        TypedQuery<FavoriteItem> query = entityManager.createQuery(jpql, FavoriteItem.class);

        return query.getResultList();
    }

    @Override
    public List<FavoriteItem> findAllWithAssociationsEntityGraph() {
        EntityGraph<FavoriteItem> graph = entityManager.createEntityGraph(FavoriteItem.class);

        graph.addAttributeNodes("user");
        graph.addAttributeNodes("listing");

        TypedQuery<FavoriteItem> query = entityManager.createQuery("SELECT fi FROM FavoriteItem fi", FavoriteItem.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getResultList();
    }




}
