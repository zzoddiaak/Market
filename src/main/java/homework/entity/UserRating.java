package homework.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "user_ratings")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "rating")
    private int rating;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "rater_id", referencedColumnName = "id")
    private List<User> rater;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "rated_user_id", referencedColumnName = "id")
    private List<User> ratedUser;
}
