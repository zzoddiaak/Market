package homework.repository.impl;

import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.UserCredential;
import homework.repository.api.UserCredentialRepository;
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
public class UserCredentialRepositoryImplTest {

    @Resource
    private UserCredentialRepository userCredentialRepository;

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
