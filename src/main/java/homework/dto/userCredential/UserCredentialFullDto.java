package homework.dto.userCredential;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCredentialFullDto {
    private long id;
    private String username;
    private String password;
    private LocalDateTime createdAt;
}

