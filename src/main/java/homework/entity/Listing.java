package homework.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "listings")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "negotiable")
    private boolean negotiable;

    @Column(name = "listing_type")
    private String listingType;

    @Column(name = "item_type")
    private String itemType;

    @Column(name = "address")
    private String address;

    @Column(name = "rental_price")
    private BigDecimal rentalPrice;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private List<User> users;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = CascadeType.MERGE)
    private List<Category> categories;
}
