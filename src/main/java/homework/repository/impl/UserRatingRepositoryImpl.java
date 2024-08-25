package homework.repository.impl;

import homework.entity.User;
import homework.entity.UserRating;
import homework.repository.AbstractRepository;
import homework.repository.api.UserRatingRepository;
import homework.repository.api.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

public class UserRatingRepositoryImpl extends AbstractRepository<UserRating> implements UserRatingRepository {
    private UserRepository userRepository;

    public UserRatingRepositoryImpl() {
        this.userRepository = new UserRepositoryImpl();
    }
    private void initializeData(){
        List<User> user = (List<User>) userRepository.findById(1L);
        List<User> user2 = (List<User>) userRepository.findById(2L);


        save(UserRating.builder()
                .ratedUser(user)
                .rating(6)
                .rater(user2)
                .createdAt(LocalDateTime.of(2024, 7, 1, 10, 0))
                .build());
    }
}
