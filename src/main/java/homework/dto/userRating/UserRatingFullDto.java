package homework.dto.userRating;

import homework.dto.user.UserFullDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRatingFullDto {
    private long id;
    private int rating;
    private LocalDateTime createdAt;

    private List<UserFullDto> rater;
    private List<UserFullDto> ratedUser;
}
