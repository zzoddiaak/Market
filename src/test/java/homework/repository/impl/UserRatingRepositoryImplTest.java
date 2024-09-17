package homework.repository.impl;

import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.UserRating;
import homework.repository.api.UserRatingRepository;
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
public class UserRatingRepositoryImplTest {

    @Resource
    private UserRatingRepository userRatingRepository;

    @Test
    public void findAll() {
        List<UserRating> ratings = userRatingRepository.findAll();
        assertNotNull(ratings);
        assertFalse(ratings.isEmpty());
    }
}
