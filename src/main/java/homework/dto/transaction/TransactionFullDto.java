package homework.dto.transaction;

import homework.dto.listingRequest.ListingRequestFullDto;
import lombok.*;

import java.time.LocalDate;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionFullDto {
    private long id;
    private LocalDate completedAt;

    private ListingRequestFullDto request;
}
