package homework.repository.impl;

import homework.entity.Role;
import homework.repository.AbstractRepository;
import homework.repository.api.RoleRepository;

public class RoleRepositoryImpl extends AbstractRepository<Role> implements RoleRepository {

    public RoleRepositoryImpl() {

        initializeData();

    }
    private void initializeData(){

        save(Role.builder()
                .name("Administrator")
                .build());
    }
}
