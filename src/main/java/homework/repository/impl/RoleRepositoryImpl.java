package homework.repository.impl;

import homework.entity.Role;
import homework.entity.Role_;
import homework.repository.AbstractRepository;
import homework.repository.api.RoleRepository;
import jakarta.persistence.EntityGraph;
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
public class RoleRepositoryImpl extends AbstractRepository<Long, Role> implements RoleRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public RoleRepositoryImpl() {
        super(Role.class);
    }

    // Criteria API
    public List<Role> findAllWithAssociationsCriteria() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> query = cb.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);

        query.select(root);

        return entityManager.createQuery(query).getResultList();
    }

    // JPQL
    public List<Role> findAllWithAssociationsJPQL() {
        String jpql = "SELECT r FROM Role r";
        TypedQuery<Role> query = entityManager.createQuery(jpql, Role.class);

        return query.getResultList();
    }

    // EntityGraph
    public List<Role> findAllWithAssociationsEntityGraph() {
        EntityGraph<Role> graph = entityManager.createEntityGraph(Role.class);

        TypedQuery<Role> query = entityManager.createQuery("SELECT r FROM Role r", Role.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getResultList();
    }


    // Поиск по имени
    public List<Role> findByNameCriteria(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Role> query = cb.createQuery(Role.class);
        Root<Role> root = query.from(Role.class);

        Predicate predicate = cb.equal(root.get(Role_.name), name);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    // Обновление данных
    @Override
    public void update(Long id, Role role) {
        Role existingRole = findById(id);
        if (existingRole != null) {
            existingRole.setName(role.getName());
            entityManager.merge(existingRole);
        }
    }
}
