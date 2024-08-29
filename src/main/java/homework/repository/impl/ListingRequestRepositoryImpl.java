package homework.repository.impl;

import homework.entity.ListingRequest;
import homework.entity.Listing;
import homework.entity.User;
import homework.repository.AbstractRepository;
import homework.repository.api.ListingRequestRepository;
import homework.repository.api.ListingRepository;
import homework.repository.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ListingRequestRepositoryImpl extends AbstractRepository<ListingRequest> implements ListingRequestRepository {

    private final UserRepository userRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public ListingRequestRepositoryImpl(UserRepository userRepository, ListingRepository listingRepository) {
        this.userRepository = userRepository;
        this.listingRepository = listingRepository;
        initializeData();
    }

    private void initializeData() {
        User user = userRepository.findById(1L);
        Listing listing = listingRepository.findById(1L);
        Listing listing2 = listingRepository.findById(2L);

        save(ListingRequest.builder()
                .listing(List.of(listing))
                .requester(List.of(user))
                .createdAt(LocalDateTime.of(2024, 7, 1, 10, 0))
                .status("Active")
                .offeredPrice(new BigDecimal("44.4"))
                .build());

        save(ListingRequest.builder()
                .listing(List.of(listing2))
                .requester(List.of(user))
                .createdAt(LocalDateTime.of(2024, 12, 5, 10, 0))
                .status("Active")
                .offeredPrice(new BigDecimal("44.4"))
                .build());
    }
}
