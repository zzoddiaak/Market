package homework.entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRating extends Entity{
    private int rating;
    private LocalDateTime createdAt;

    private List<User> rater;
    private List<User> ratedUser;
}
