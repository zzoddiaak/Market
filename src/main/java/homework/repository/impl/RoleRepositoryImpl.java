package homework.repository.impl;

import homework.entity.Role;
import homework.entity.Role_;
import homework.repository.AbstractRepository;
import homework.repository.api.RoleRepository;
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

    // Поиск по ID
    @Override
    public Role findById(Long id) {
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT r FROM Role r WHERE r.id = :id", Role.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

    // Поиск всех ролей
    @Override
    public List<Role> findAll() {
        TypedQuery<Role> query = entityManager.createQuery(
                "SELECT r FROM Role r", Role.class);
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
