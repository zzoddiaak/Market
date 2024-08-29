package homework.entity;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCredential extends Entity{
    private String username;
    private String password;
    private LocalDateTime createdAt;
}
