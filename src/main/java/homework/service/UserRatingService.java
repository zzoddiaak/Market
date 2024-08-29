package homework.service;

import homework.dto.userRating.UserRatingFullDto;
import java.util.List;

public interface UserRatingService {
    List<UserRatingFullDto> findAll();
    UserRatingFullDto findById(long id);
    void save(UserRatingFullDto object);
    void update(long id,UserRatingFullDto  updateDTO);
    void deleteById(long id);
}
