package homework.repository.impl;

import homework.entity.Listing;
import homework.entity.User;
import homework.repository.AbstractRepository;
import homework.repository.api.ListingRepository;
import homework.repository.api.UserRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ListingRepositoryImpl extends AbstractRepository<Listing> implements ListingRepository {
    private UserRepository userRepository;
    public ListingRepositoryImpl() {
        this.userRepository = new UserRepositoryImpl();
        initializeData();
    }
    private void initializeData(){
        List<User> user = (List<User>) userRepository.findById(1L);
        save(Listing.builder()
                .address("Grodno")
                .users(user)
                .price(new BigDecimal("32.3"))
                .title("Hoh")
                .listingType("Active")
                .createdAt(LocalDateTime.of(2024, 7, 1, 10, 0))
                .description("Pppd")
                .negotiable(true)
                .rentalPrice(new BigDecimal("32.3"))
                .build());
    }
}
