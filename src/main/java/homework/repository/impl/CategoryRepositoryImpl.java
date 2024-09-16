package homework.repository.impl;

import homework.entity.Category;
import homework.entity.Category_;
import homework.repository.AbstractRepository;
import homework.repository.api.CategoryRepository;
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
public class CategoryRepositoryImpl extends AbstractRepository<Long, Category> implements CategoryRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CategoryRepositoryImpl() {
        super(Category.class);
    }


    // JPQL
    public List<Category> findAllWithAssociationsJPQL() {
        String jpql = "SELECT c FROM Category c";
        TypedQuery<Category> query = entityManager.createQuery(jpql, Category.class);

        return query.getResultList();
    }

    // EntityGraph
    public List<Category> findAllWithAssociationsEntityGraph() {
        EntityGraph<Category> graph = entityManager.createEntityGraph(Category.class);

        TypedQuery<Category> query = entityManager.createQuery("SELECT c FROM Category c", Category.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getResultList();
    }


    //  Поиск по имени
    public List<Category> findByNameCriteria(String name) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> query = cb.createQuery(Category.class);
        Root<Category> root = query.from(Category.class);

        Predicate predicate = cb.equal(root.get(Category_.name), name);
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    public void update(Long id, Category category) {
        Category existingCategory = findById(id);
        if (existingCategory != null) {
            existingCategory.setName(category.getName());
            entityManager.merge(existingCategory);
        }
    }
}
