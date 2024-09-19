package homework.repository.impl;

import homework.config.test.TestConfig;
import homework.entity.Role;
import homework.entity.User;
import homework.entity.UserCredential;
import homework.repository.api.RoleRepository;
import homework.repository.api.UserCredentialRepository;
import homework.repository.api.UserRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class UserRepositoryImplTest {

    @Resource
    private UserRepository userRepository;

    @Resource
    private UserCredentialRepository userCredentialRepository;

    @Resource
    private RoleRepository roleRepository;

    @Before
    public void setUp() {
        Role role1 = Role.builder().name("USER").build();
        Role role2 = Role.builder().name("ADMIN").build();
        roleRepository.save(role1);
        roleRepository.save(role2);

        UserCredential credential = UserCredential.builder()
                .username("testuser")
                .password("password")
                .createdAt(LocalDateTime.now())
                .build();
        userCredentialRepository.save(credential);

        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .bio("Test user")
                .createdAt(LocalDateTime.now())
                .credential(credential)
                .role(Arrays.asList(role1, role2))
                .build();
        userRepository.save(user);
    }

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
