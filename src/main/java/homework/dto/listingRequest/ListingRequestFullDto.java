package homework.dto.listingRequest;

import homework.dto.listing.ListingFullDto;
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
public class ListingRequestFullDto {
    private long id;
    private BigDecimal offeredPrice;
    private String status;
    private LocalDateTime createdAt;

    private List<ListingFullDto> listing;
    private List<UserFullDto> requester;
}
