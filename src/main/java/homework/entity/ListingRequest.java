package homework.entity;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListingRequest {
    private long id;
    private BigDecimal offeredPrice;
    private String status;
    private LocalDateTime createdAt;

    private List<Listing> listing;
    private List<User> requester;
}
