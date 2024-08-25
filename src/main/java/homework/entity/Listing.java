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
public class Listing extends Entity{
    private String title;
    private String description;
    private BigDecimal price;
    private boolean negotiable;
    private String listingType;
    private String itemType;
    private String address;
    private BigDecimal rentalPrice;
    private LocalDateTime createdAt;

    private List<User> users;
}
