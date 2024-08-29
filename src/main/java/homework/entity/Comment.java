package homework.entity;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comment extends Entity{
    private String commentText;
    private LocalDateTime createdAt;

    private User user;
}
