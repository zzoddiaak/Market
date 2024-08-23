package homework.entity;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRole {
    private List<Role> roles;
    private List<User> users;
}
