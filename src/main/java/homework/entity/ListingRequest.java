package homework.entity;

import jakarta.persistence.Column;
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
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

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
    private Long id;

    @Column(name = "offered_price")
    private BigDecimal offeredPrice;

    @Column(name = "status")
    private String status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "listing_id", referencedColumnName = "id")
    private Set<Listing> listing;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "requester_id", referencedColumnName = "id")
    private Set<User> requester;
}

