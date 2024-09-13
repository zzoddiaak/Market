package homework.entity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "favorite_items")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<User> user;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", referencedColumnName = "id")
    private List<Listing> listing;
}
