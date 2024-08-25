package homework.repository.api;

import homework.entity.UserRating;

import java.util.List;

public interface UserRatingRepository {
    UserRating findById(Long id);
    List<UserRating> findAll();
    void save(UserRating userRating);
    void deleteById(Long id);
}
