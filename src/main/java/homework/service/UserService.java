package homework.service;

import homework.dto.user.UserFullDto;
import java.util.List;

public interface UserService {
    List<UserFullDto> findAll();
    UserFullDto findById(long id);
    void save(UserFullDto object);
    void update(long id,UserFullDto  updateDTO);
    void deleteById(long id);
}
