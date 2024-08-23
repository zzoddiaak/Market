package homework.entity;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    private long id;
    private String name;
}
