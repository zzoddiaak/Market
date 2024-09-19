package homework.repository.impl;

import homework.config.test.TestConfig;
import homework.entity.FavoriteItem;
import homework.entity.Listing;
import homework.entity.User;
import homework.repository.api.FavoriteItemRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class FavoriteItemRepositoryImplTest {

    @Resource
    private FavoriteItemRepository favoriteItemRepository;

    @Before
    public void setUp() {
        User user = new User();
        user.setFirstName("John");
        user.setLastName("Doe");

        Listing listing1 = new Listing();
        listing1.setTitle("Listing 1");

        Listing listing2 = new Listing();
        listing2.setTitle("Listing 2");

        FavoriteItem favoriteItem = FavoriteItem.builder()
                .user(Set.of(user))
                .listing(Set.of(listing1, listing2))
                .build();

        favoriteItemRepository.save(favoriteItem);
    }

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
