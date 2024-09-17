package homework.repository.impl;

import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.Role;
import homework.repository.api.RoleRepository;
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
public class RoleRepositoryImplTest {

    @Resource
    private RoleRepository roleRepository;

    @Test
    public void findAllWithAssociationsCriteria() {
        List<Role> roles = roleRepository.findAllWithAssociationsCriteria();
        assertNotNull(roles);
        assertFalse(roles.isEmpty());
    }

    @Test
    public void findAllWithAssociationsJPQL() {
        List<Role> roles = roleRepository.findAllWithAssociationsJPQL();
        assertNotNull(roles);
        assertFalse(roles.isEmpty());
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<Role> roles = roleRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(roles);
        assertFalse(roles.isEmpty());
    }

    @Test
    public void findByNameCriteria() {
        String name = "ADMIN";
        List<Role> roles = roleRepository.findByNameCriteria(name);
        assertNotNull(roles);
        assertFalse(roles.isEmpty());
    }
}
