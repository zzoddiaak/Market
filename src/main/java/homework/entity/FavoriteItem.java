package homework.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Long id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Set<User> user = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", referencedColumnName = "id")
    private Set<Listing> listing = new HashSet<>();

}
