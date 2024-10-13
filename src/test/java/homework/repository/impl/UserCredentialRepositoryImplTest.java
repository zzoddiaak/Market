package homework.repository.impl;

import homework.config.test.TestConfig;
import homework.entity.UserCredential;
import homework.repository.api.UserCredentialRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
@ActiveProfiles("test")
public class UserCredentialRepositoryImplTest {

    @Resource
    private UserCredentialRepository userCredentialRepository;

    @Before
    public void setUp() {
        UserCredential userCredential = UserCredential.builder()
                .username("testuser")
                .password("testpassword")
                .createdAt(LocalDateTime.now())
                .build();
        userCredentialRepository.save(userCredential);
    }

    @Test
    public void findAllWithAssociationsCriteria() {
        List<UserCredential> credentials = userCredentialRepository.findAllWithAssociationsCriteria();
        assertNotNull(credentials);
        assertFalse(credentials.isEmpty());
    }

    @Test
    public void findAllWithAssociationsJPQL() {
        List<UserCredential> credentials = userCredentialRepository.findAllWithAssociationsJPQL();
        assertNotNull(credentials);
        assertFalse(credentials.isEmpty());
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<UserCredential> credentials = userCredentialRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(credentials);
        assertFalse(credentials.isEmpty());
    }
}
