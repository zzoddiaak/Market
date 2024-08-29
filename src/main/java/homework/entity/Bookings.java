package homework.entity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bookings extends Entity{
    private String status;
    private LocalDateTime crearedAt;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

    private List<Listing> listing;
    private List<User> users;

}
