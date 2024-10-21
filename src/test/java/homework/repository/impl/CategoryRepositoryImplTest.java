package homework.repository.impl;

import homework.config.test.TestConfig;
import homework.entity.Category;
import homework.repository.api.CategoryRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
@ActiveProfiles("test")
public class CategoryRepositoryImplTest {

    @Resource
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() {
        Category category1 = Category.builder().name("Electronics").build();
        Category category2 = Category.builder().name("Books").build();
        Category category3 = Category.builder().name("Clothing").build();

        categoryRepository.save(category1);
        categoryRepository.save(category2);
        categoryRepository.save(category3);
    }

    @Test
    public void findByNameCriteria() {
        List<Category> categories = categoryRepository.findByNameCriteria("Electronics");
        assertNotNull(categories);
        assertFalse(categories.isEmpty());

        categories.forEach(c -> assertEquals("Electronics", c.getName()));
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<Category> categories = categoryRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(categories);
        assertFalse(categories.isEmpty());
    }
}
