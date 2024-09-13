package homework.repository.impl;

import homework.entity.User;
import homework.entity.User_;
import homework.repository.AbstractRepository;
import homework.repository.api.UserRepository;
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
public class UserRepositoryImpl extends AbstractRepository<Long, User> implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl() {
        super(User.class);
    }

    // JPQL запрос: Поиск по ID
    @Override
    public User findById(Long id) {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u WHERE u.id = :id", User.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    // JPQL запрос: Поиск всех пользователей
    @Override
    public List<User> findAll() {
        TypedQuery<User> query = entityManager.createQuery(
                "SELECT u FROM User u", User.class);
        return query.getResultList();
    }

    // Criteria API запрос: Поиск по имени
    public List<User> findByFirstNameCriteria(String firstName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        Predicate predicate = cb.equal(root.get(User_.firstName), firstName);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    // Обновление данных
    @Override
    public void update(Long id, User user) {
        User existingUser = findById(id);
        if (existingUser != null) {
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setBio(user.getBio());
            existingUser.setCreatedAt(user.getCreatedAt());
            existingUser.setCredential(user.getCredential());
            existingUser.setRole(user.getRole());
            entityManager.merge(existingUser);
        }
    }
}
