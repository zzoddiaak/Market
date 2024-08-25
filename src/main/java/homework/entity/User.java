package homework.entity;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends Entity{
    private String firstName;
    private String lastName;
    private String bio;
    private LocalDateTime createdAt;

    private UserCredential credential;
}
