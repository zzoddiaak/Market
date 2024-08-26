package homework.repository.api;

import homework.entity.UserCredential;

import java.util.List;

public interface UserCredentialRepository {
    UserCredential findById(Long id);
    List<UserCredential> findAll();
    void save(UserCredential userCredential);
    void deleteById(Long id);
    void update(Long id, UserCredential userCredential);

}