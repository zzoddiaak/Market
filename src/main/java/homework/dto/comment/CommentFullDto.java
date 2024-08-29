package homework.dto.comment;

import homework.dto.user.UserFullDto;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentFullDto {
    private long id;

    private String commentText;
    private LocalDateTime createdAt;

    private UserFullDto user;

}
