package homework.service;

import homework.dto.role.RoleFullDto;
import java.util.List;

public interface RoleService {
    List<RoleFullDto> findAll();
    RoleFullDto findById(long id);
    void save(RoleFullDto object);
    void deleteById(long id);
    void update(long id,RoleFullDto object);
    RoleFullDto findByRoleName(String roleName);
}
