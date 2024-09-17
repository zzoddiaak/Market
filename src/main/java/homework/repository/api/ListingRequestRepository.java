package homework.repository.api;

import homework.entity.ListingRequest;

import java.math.BigDecimal;
import java.util.List;

public interface ListingRequestRepository {
    ListingRequest findById(Long id);
    List<ListingRequest> findAll();
    void save(ListingRequest listingRequest);
    void deleteById(Long id);
    void update(ListingRequest listingRequest);
    List<ListingRequest> findAllWithAssociationsCriteria();
    List<ListingRequest> findAllWithAssociationsJPQL();
    List<ListingRequest> findAllWithAssociationsEntityGraph();
    List<ListingRequest> findByOfferedPriceCriteria(BigDecimal offeredPrice);

}
