package homework.service;

import homework.dto.listing.ListingFullDto;
import java.util.List;

public interface ListingService {
    List<ListingFullDto> findAll();
    ListingFullDto findById(long id);
    void save(ListingFullDto object);
    void deleteById(long id);
    void update(long id,ListingFullDto object);
}
