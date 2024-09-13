package homework.repository.impl;

import homework.entity.UserRating;

import homework.repository.AbstractRepository;
import homework.repository.api.UserRatingRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRatingRepositoryImpl extends AbstractRepository<Long, UserRating> implements UserRatingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRatingRepositoryImpl() {
        super(UserRating.class);
    }

    // JPQL запрос: Поиск по ID
    @Override
    public UserRating findById(Long id) {
        TypedQuery<UserRating> query = entityManager.createQuery(
                "SELECT ur FROM UserRating ur WHERE ur.id = :id", UserRating.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    // JPQL запрос: Поиск всех оценок
    @Override
    public List<UserRating> findAll() {
        TypedQuery<UserRating> query = entityManager.createQuery(
                "SELECT ur FROM UserRating ur", UserRating.class);
        return query.getResultList();
    }




    // Обновление данных
    @Override
    public void update(Long id, UserRating userRating) {
        UserRating existingUserRating = findById(id);
        if (existingUserRating != null) {
            existingUserRating.setRating(userRating.getRating());
            existingUserRating.setCreatedAt(userRating.getCreatedAt());
            existingUserRating.setRater(userRating.getRater());
            existingUserRating.setRatedUser(userRating.getRatedUser());
            entityManager.merge(existingUserRating);
        }
    }
}
