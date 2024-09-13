package homework.entity;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "listing_requests")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListingRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "offered_price")
    private BigDecimal offeredPrice;
    @Column(name = "status")
    private String status;
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", referencedColumnName = "id")
    private List<Listing> listing;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", referencedColumnName = "id")
    private List<User> requester;
}
