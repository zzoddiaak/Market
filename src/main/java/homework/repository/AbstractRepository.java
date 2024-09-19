package homework.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public abstract class AbstractRepository<ID, T> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> entityClass;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public T findById(ID id) {
        return entityManager.find(entityClass, id);
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public List<T> findAll() {
        String queryString = String.format("SELECT u FROM %s u", entityClass.getSimpleName());
        TypedQuery<T> query = entityManager.createQuery(queryString, entityClass);
        return query.getResultList();
    }

    public void deleteById(ID id) {
        T entity = findById(id);
        if (entity != null) {
            entityManager.remove(entity);
        }
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }
}
