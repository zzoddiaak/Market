package homework.service;

import homework.dto.favoriteItem.FavoriteItemFullDto;
import java.util.List;

public interface FavoriteItemService {
    List<FavoriteItemFullDto> findAll();
    FavoriteItemFullDto findById(long id);
    void save(FavoriteItemFullDto object);
    void update(long id,FavoriteItemFullDto  updateDTO);
    void deleteById(long id);
}
