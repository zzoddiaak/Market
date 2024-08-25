package homework.repository.impl;

import homework.entity.Bookings;
import homework.entity.Category;
import homework.repository.AbstractRepository;
import homework.repository.api.BookingsRepository;
import homework.repository.api.CategoryRepository;

public class CategoryRepositoryImpl extends AbstractRepository<Category> implements CategoryRepository {


    public CategoryRepositoryImpl(){
        initializeData();
    }
    private void initializeData(){

        save(Category.builder()
                .name("Drop")
                .build());
    }

}
