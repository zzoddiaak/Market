package homework.repository.impl;

import homework.entity.Role;
import homework.repository.AbstractRepository;
import homework.repository.api.RoleRepository;
import org.springframework.stereotype.Repository;


@Repository
public class RoleRepositoryImpl extends AbstractRepository<Role> implements RoleRepository {

    public RoleRepositoryImpl() {

        initializeData();

    }
    private void initializeData(){

        save(Role.builder()
                .name("Administrator")
                .build());

        save(Role.builder()
                .name("User")
                .build());
    }
}
