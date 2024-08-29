package homework.repository.impl;

import homework.entity.Category;
import homework.repository.AbstractRepository;
import homework.repository.api.CategoryRepository;
import org.springframework.stereotype.Repository;


@Repository
public class CategoryRepositoryImpl extends AbstractRepository<Category> implements CategoryRepository {


    public CategoryRepositoryImpl(){
        initializeData();
    }
    private void initializeData(){

        save(Category.builder()
                .name("Phone")
                .build());

        save(Category.builder()
                .name("Table")
                .build());
    }

}
