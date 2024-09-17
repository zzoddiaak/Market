package homework.repository.impl;

import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.Category;
import homework.repository.api.CategoryRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class, LiquibaseConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class CategoryRepositoryImplTest {

    @Resource
    private CategoryRepository categoryRepository;

    @Test
    public void findByNameCriteria() {
        Category category = Category.builder().name("Electronics").build();
        categoryRepository.save(category);

        List<Category> categories = categoryRepository.findByNameCriteria("Electronics");
        assertNotNull(categories);
        assertFalse(categories.isEmpty());

        categories.forEach(c -> assertEquals("Electronics", c.getName()));
    }

    @Test
    public void findAllWithAssociationsJPQL() {
        List<Category> categories = categoryRepository.findAllWithAssociationsJPQL();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<Category> categories = categoryRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }
}
