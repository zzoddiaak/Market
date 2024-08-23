package homework.entity;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ListingCategory {
    private List<Listing> listings;
    private List<Category> category;
}
