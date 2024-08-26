package homework.service;


import homework.dto.category.CategoryFullDto;
import java.util.List;

public interface CategoryService {

    List<CategoryFullDto> findAll();
    CategoryFullDto findById(long id);
    void save(CategoryFullDto object);
    void update(long id,CategoryFullDto  updateDTO);
    void deleteById(long id);
}
