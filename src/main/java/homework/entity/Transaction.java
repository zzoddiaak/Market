package homework.entity;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    private long id;
    private LocalDate completedAt;

    private ListingRequest request;

}
