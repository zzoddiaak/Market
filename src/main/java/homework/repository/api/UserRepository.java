package homework.repository.api;

import homework.entity.User;

import java.util.List;

public interface UserRepository {
    User  findById(Long id);
    List<User> findAll();
    void save(User user);
    void deleteById(Long id);
    void update(Long id, User user);

}
