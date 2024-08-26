package homework.repository.api;

import homework.entity.Role;

import java.util.List;

public interface RoleRepository {
    Role findById(Long id);
    List<Role> findAll();
    void save(Role role);
    void deleteById(Long id);
    void update(Long id, Role role);

}
