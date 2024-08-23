package homework.entity;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {
    private long id;
    private String name;
}
