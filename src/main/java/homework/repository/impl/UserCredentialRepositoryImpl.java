package homework.repository.impl;

import homework.entity.UserCredential;
import homework.entity.UserCredential_;
import homework.repository.AbstractRepository;
import homework.repository.api.UserCredentialRepository;
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
public class UserCredentialRepositoryImpl extends AbstractRepository<Long, UserCredential> implements UserCredentialRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserCredentialRepositoryImpl() {
        super(UserCredential.class);
    }

    // Поиск по ID
    @Override
    public UserCredential findById(Long id) {
        TypedQuery<UserCredential> query = entityManager.createQuery(
                "SELECT uc FROM UserCredential uc WHERE uc.id = :id", UserCredential.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    // Поиск всех учетных записей
    @Override
    public List<UserCredential> findAll() {
        TypedQuery<UserCredential> query = entityManager.createQuery(
                "SELECT uc FROM UserCredential uc", UserCredential.class);
        return query.getResultList();
    }

    // Поиск по имени пользователя
    public List<UserCredential> findByUsernameCriteria(String username) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserCredential> query = cb.createQuery(UserCredential.class);
        Root<UserCredential> root = query.from(UserCredential.class);

        Predicate predicate = cb.equal(root.get(UserCredential_.username), username);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void update(Long id, UserCredential userCredential) {
        UserCredential existingUserCredential = findById(id);
        if (existingUserCredential != null) {
            existingUserCredential.setUsername(userCredential.getUsername());
            existingUserCredential.setPassword(userCredential.getPassword());
            existingUserCredential.setCreatedAt(userCredential.getCreatedAt());
            entityManager.merge(existingUserCredential);
        }
    }
}
