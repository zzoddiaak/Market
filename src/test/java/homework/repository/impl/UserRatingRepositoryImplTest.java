package homework.repository.impl;

import homework.config.TestConfig;
import homework.entity.User;
import homework.entity.UserRating;
import homework.repository.api.UserRatingRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class UserRatingRepositoryImplTest {

    @Resource
    private UserRatingRepository userRatingRepository;

    @Before
    public void setUp() {
        User rater = new User();
        rater.setId(1L);

        User ratedUser = new User();
        ratedUser.setId(2L);

        List<User> raterList = new ArrayList<>();
        raterList.add(rater);

        List<User> ratedUserList = new ArrayList<>();
        ratedUserList.add(ratedUser);

        UserRating userRating = UserRating.builder()
                .rating(5)
                .createdAt(LocalDateTime.now())
                .rater(raterList)
                .ratedUser(ratedUserList)
                .build();

        userRatingRepository.save(userRating);
    }

    @Test
    public void findAll() {
        List<UserRating> ratings = userRatingRepository.findAll();
        assertNotNull(ratings);
        assertFalse(ratings.isEmpty());
    }
}
