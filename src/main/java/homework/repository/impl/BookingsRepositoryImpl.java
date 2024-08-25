package homework.repository.impl;

import homework.entity.Bookings;
import homework.entity.Listing;
import homework.entity.User;
import homework.repository.AbstractRepository;
import homework.repository.api.BookingsRepository;
import homework.repository.api.ListingRepository;
import homework.repository.api.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

public class BookingsRepositoryImpl extends AbstractRepository<Bookings> implements BookingsRepository {
    private UserRepository userRepository;
    private ListingRepository listingRepository;

    public BookingsRepositoryImpl() {
        this.userRepository = new UserRepositoryImpl();
        this.listingRepository = new ListingRepositoryImpl();
        initializeData();
    }

    private void initializeData(){
        List<User> user = (List<User>) userRepository.findById(1L);
        List<Listing> listing = (List<Listing>) listingRepository.findById(1L);

        save(Bookings.builder()
                .users(user)
                .listing(listing)
                .status("Active")
                .startDate(LocalDateTime.of(2024, 7, 1, 10, 0))
                .endDate(LocalDateTime.of(2024, 9,1,10,0))
                .crearedAt(LocalDateTime.of(2024, 7, 1, 10, 0))
                .build());

    }

}
