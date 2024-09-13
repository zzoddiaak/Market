package homework.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@Table(name = "roles")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;
}
