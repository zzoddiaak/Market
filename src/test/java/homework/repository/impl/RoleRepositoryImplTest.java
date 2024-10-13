package homework.repository.impl;

import homework.config.test.TestConfig;
import homework.entity.Role;
import homework.repository.api.RoleRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
@ActiveProfiles("test")
public class RoleRepositoryImplTest {

    @Resource
    private RoleRepository roleRepository;

    @Before
    public void setUp() {
        Role adminRole = new Role();
        adminRole.setName("ADMIN");
        roleRepository.save(adminRole);

        Role userRole = new Role();
        userRole.setName("USER");
        roleRepository.save(userRole);
    }

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

}
