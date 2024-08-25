package homework.repository.impl;

import homework.entity.Listing;
import homework.entity.ListingRequest;
import homework.entity.User;
import homework.repository.AbstractRepository;
import homework.repository.api.ListingRepository;
import homework.repository.api.ListingRequestRepository;
import homework.repository.api.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ListingRequestRepositoryImpl extends AbstractRepository<ListingRequest> implements ListingRequestRepository {

    private UserRepository userRepository;
    private ListingRepository listingRepository;

    public ListingRequestRepositoryImpl() {

        this.userRepository = new UserRepositoryImpl();
        this.listingRepository = new ListingRepositoryImpl();
        initializeData();

    }

    private void initializeData(){

        List<User> user = (List<User>) userRepository.findById(1L);
        List<Listing> listing = (List<Listing>) listingRepository.findById(1L);

       save(ListingRequest.builder()
               .listing(listing)
               .requester(user)
               .createdAt(LocalDateTime.of(2024, 7, 1, 10, 0))
               .status("Active")
               .offeredPrice(new BigDecimal("44.4"))
               .build());

    }

}
