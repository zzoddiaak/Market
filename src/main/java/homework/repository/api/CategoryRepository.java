package homework.repository.api;



import homework.entity.Category;

import java.util.List;

public interface CategoryRepository {
    Category findById(Long id);
    List<Category> findAll();
    void save(Category category);
    void deleteById(Long id);
    void update(Category category);
    List<Category> findAllWithAssociationsEntityGraph();
    List<Category> findByNameCriteria(String name);

}
