package homework.repository.api;

import homework.entity.ListingRequest;

import java.util.List;

public interface ListingRequestRepository {
    ListingRequest findById(Long id);
    List<ListingRequest> findAll();
    void save(ListingRequest listingRequest);
    void deleteById(Long id);
}
