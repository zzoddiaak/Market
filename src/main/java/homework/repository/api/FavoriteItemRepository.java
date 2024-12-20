package homework.repository.api;

import homework.entity.FavoriteItem;

import java.util.List;

public interface FavoriteItemRepository {
    FavoriteItem findById(Long id);
    List<FavoriteItem> findAll();
    void save(FavoriteItem favoriteItem);
    void deleteById(Long id);
    void update(FavoriteItem favoriteItem);
    List<FavoriteItem> findAllWithAssociationsCriteria();
    List<FavoriteItem> findAllWithAssociationsJPQL();
    List<FavoriteItem> findAllWithAssociationsEntityGraph();

}
