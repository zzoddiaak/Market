package homework.service;

import homework.dto.userRating.UserRatingFullDto;
import java.util.List;

public interface UserRatingService {
    List<UserRatingFullDto> findAll();
    UserRatingFullDto findById(long id);
    void save(UserRatingFullDto object);
    void deleteById(long id);
    void update(long id,UserRatingFullDto object);
}
