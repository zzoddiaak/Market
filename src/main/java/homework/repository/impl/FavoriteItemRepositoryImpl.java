package homework.repository.impl;

import homework.entity.FavoriteItem;
import homework.entity.FavoriteItem_;
import homework.repository.AbstractRepository;
import homework.repository.api.FavoriteItemRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FavoriteItemRepositoryImpl extends AbstractRepository<Long, FavoriteItem> implements FavoriteItemRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public FavoriteItemRepositoryImpl() {
        super(FavoriteItem.class);
    }

    // Поиск по ID пользователя
    public List<FavoriteItem> findByUserIdJPQL(Long userId) {
        TypedQuery<FavoriteItem> query = entityManager.createQuery(
                "SELECT f FROM FavoriteItem f WHERE f.user.id = :userId", FavoriteItem.class);
        query.setParameter("userId", userId);
        return query.getResultList();
    }

    // Поиск по ID пользователя
    public List<FavoriteItem> findByUserIdCriteria(Long userId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<FavoriteItem> query = cb.createQuery(FavoriteItem.class);
        Root<FavoriteItem> root = query.from(FavoriteItem.class);

        Predicate predicate = cb.equal(root.join(FavoriteItem_.user).get("id"), userId);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
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
