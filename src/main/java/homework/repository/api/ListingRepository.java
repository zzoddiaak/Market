package homework.repository.api;

import homework.entity.FavoriteItem;
import homework.entity.Listing;

import java.util.List;

public interface ListingRepository {
    Listing findById(Long id);
    List<Listing> findAll();
    void save(Listing listing);
    void deleteById(Long id);
}
