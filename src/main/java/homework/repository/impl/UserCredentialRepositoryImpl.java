package homework.repository.impl;

import homework.entity.UserCredential;
import homework.repository.AbstractRepository;
import homework.repository.api.UserCredentialRepository;
import jakarta.persistence.EntityGraph;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
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

    @Override
    public List<UserCredential> findAllWithAssociationsCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserCredential> query = cb.createQuery(UserCredential.class);
        Root<UserCredential> root = query.from(UserCredential.class);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public List<UserCredential> findAllWithAssociationsJPQL() {
        String jpql = "SELECT uc FROM UserCredential uc";
        TypedQuery<UserCredential> query = entityManager.createQuery(jpql, UserCredential.class);

        return query.getResultList();
    }

    @Override
    public List<UserCredential> findAllWithAssociationsEntityGraph() {
        EntityGraph<UserCredential> graph = entityManager.createEntityGraph(UserCredential.class);

        TypedQuery<UserCredential> query = entityManager.createQuery("SELECT uc FROM UserCredential uc", UserCredential.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getResultList();
    }



}
