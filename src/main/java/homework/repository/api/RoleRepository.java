package homework.repository.api;

import homework.entity.Role;

import java.util.List;

public interface RoleRepository {
    Role findById(Long id);
    List<Role> findAll();
    void save(Role role);
    void deleteById(Long id);
    void update(Role role);
    List<Role> findAllWithAssociationsEntityGraph();
    List<Role> findAllWithAssociationsJPQL();
    List<Role> findAllWithAssociationsCriteria();
    List<Role> findByRoleName(String roleName);


}
