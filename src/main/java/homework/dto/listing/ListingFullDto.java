package homework.dto.listing;

import homework.dto.user.UserFullDto;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListingFullDto {
    private long id;
    private String title;
    private String description;
    private BigDecimal price;
    private boolean negotiable;
    private String listingType;
    private String itemType;
    private String address;
    private BigDecimal rentalPrice;
    private LocalDateTime createdAt;

    private List<UserFullDto> users;
}
