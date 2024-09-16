package homework.repository.impl;

import homework.entity.User;
import homework.entity.User_;
import homework.repository.AbstractRepository;
import homework.repository.api.UserRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl extends AbstractRepository<Long, User> implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public UserRepositoryImpl() {
        super(User.class);
    }

    // Criteria API
    public List<User> findAllWithAssociationsCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);
        Root<User> root = query.from(User.class);

        root.fetch(User_.credential, JoinType.LEFT);
        root.fetch(User_.role, JoinType.LEFT);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    // JPQL
    public List<User> findAllWithAssociationsJPQL() {
        String jpql = "SELECT u FROM User u " +
                "LEFT JOIN FETCH u.credential " +
                "LEFT JOIN FETCH u.role";
        TypedQuery<User> query = entityManager.createQuery(jpql, User.class);

        return query.getResultList();
    }

    // EntityGraph
    public List<User> findAllWithAssociationsEntityGraph() {
        EntityGraph<User> graph = entityManager.createEntityGraph(User.class);

        graph.addAttributeNodes("credential");
        graph.addAttributeNodes("role");

        TypedQuery<User> query = entityManager.createQuery("SELECT u FROM User u", User.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getResultList();
    }

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
