package homework.entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRating {
    private long id;
    private int rating;
    private LocalDateTime createdAt;

    private List<User> rater;
    private List<User> ratedUser;
}
