package homework.dto.favoriteItem;

import homework.dto.listing.ListingFullDto;
import homework.dto.user.UserFullDto;
import lombok.*;

import java.util.List;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteItemFullDto {
    private List<UserFullDto> user;
    private List<ListingFullDto> listing;
}
