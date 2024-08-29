package homework.service;

import homework.dto.role.RoleFullDto;
import java.util.List;

public interface RoleService {
    List<RoleFullDto> findAll();
    RoleFullDto findById(long id);
    void save(RoleFullDto object);
    void update(long id,RoleFullDto  updateDTO);
    void deleteById(long id);
}
