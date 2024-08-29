package homework.dto.booking;

import homework.dto.listing.ListingFullDto;
import homework.dto.user.UserFullDto;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookingFullDto {
    private long id;
    private String status;
    private LocalDateTime crearedAt;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<ListingFullDto> listing;
    private List<UserFullDto> users;
}
