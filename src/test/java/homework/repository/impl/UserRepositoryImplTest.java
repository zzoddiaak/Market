package homework.repository.impl;


import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.User;
import homework.repository.api.UserRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
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
public class UserRepositoryImplTest {

    @Resource
    private UserRepository userRepository;

    @Test
    public void findAllWithAssociationsCriteria() {
        List<User> users = userRepository.findAllWithAssociationsCriteria();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    public void findAllWithAssociationsJPQL() {
        List<User> users = userRepository.findAllWithAssociationsJPQL();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<User> users = userRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(users);
        assertFalse(users.isEmpty());
    }
}
