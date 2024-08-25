package homework.dto.user;

import homework.dto.userCredential.UserCredentialFullDto;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserFullDto {
    private long id;
    private String firstName;
    private String lastName;
    private String bio;
    private LocalDateTime createdAt;

    private UserCredentialFullDto credential;
}
