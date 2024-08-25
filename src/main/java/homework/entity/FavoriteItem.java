package homework.entity;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteItem extends Entity{
    private List<User> user;
    private List<Listing> listing;
}
