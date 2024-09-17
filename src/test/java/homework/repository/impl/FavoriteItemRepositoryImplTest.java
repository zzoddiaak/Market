package homework.repository.impl;

import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.FavoriteItem;
import homework.repository.api.FavoriteItemRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class, LiquibaseConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class FavoriteItemRepositoryImplTest {

    @Resource
    private FavoriteItemRepository favoriteItemRepository;

    @Test
    public void findAllWithAssociationsCriteria() {
        List<FavoriteItem> favoriteItems = favoriteItemRepository.findAllWithAssociationsCriteria();
        assertNotNull(favoriteItems);
        assertFalse(favoriteItems.isEmpty());
    }

    @Test
    public void findAllWithAssociationsJPQL() {
        List<FavoriteItem> favoriteItems = favoriteItemRepository.findAllWithAssociationsJPQL();
        assertNotNull(favoriteItems);
        assertFalse(favoriteItems.isEmpty());
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<FavoriteItem> favoriteItems = favoriteItemRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(favoriteItems);
        assertFalse(favoriteItems.isEmpty());
    }
}
