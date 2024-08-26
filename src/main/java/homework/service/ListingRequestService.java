package homework.service;

import homework.dto.listingRequest.ListingRequestFullDto;
import java.util.List;

public interface ListingRequestService {
    List<ListingRequestFullDto> findAll();
    ListingRequestFullDto findById(long id);
    void save(ListingRequestFullDto object);
    void update(long id,ListingRequestFullDto  updateDTO);
    void deleteById(long id);
}
