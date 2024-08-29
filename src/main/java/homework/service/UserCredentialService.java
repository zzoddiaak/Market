package homework.service;

import homework.dto.userCredential.UserCredentialFullDto;
import java.util.List;

public interface UserCredentialService {
    List<UserCredentialFullDto> findAll();
    UserCredentialFullDto findById(long id);
    void save(UserCredentialFullDto object);
    void update(long id,UserCredentialFullDto  updateDTO);
    void deleteById(long id);
}
