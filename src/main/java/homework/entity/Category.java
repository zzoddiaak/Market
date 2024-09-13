package homework.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name = "categories")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
}
