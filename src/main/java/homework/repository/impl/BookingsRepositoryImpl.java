package homework.repository.impl;

import homework.entity.Bookings;
import homework.entity.Listing;
import homework.entity.User;
import homework.repository.AbstractRepository;
import homework.repository.api.BookingsRepository;
import homework.repository.api.ListingRepository;
import homework.repository.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@Repository
public class BookingsRepositoryImpl extends AbstractRepository<Bookings> implements BookingsRepository {

    private final UserRepository userRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public BookingsRepositoryImpl(UserRepository userRepository, ListingRepository listingRepository) {
        this.userRepository = userRepository;
        this.listingRepository = listingRepository;
        initializeData();
    }

    private void initializeData() {
        User user = userRepository.findById(1L);
        Listing listing = listingRepository.findById(1L);
        User user1 = userRepository.findById(2L);
        Listing listing1 = listingRepository.findById(2L);

        save(Bookings.builder()
                .users(List.of(user))
                .listing(Collections.singletonList(listing))
                .status("Active")
                .startDate(LocalDateTime.of(2024, 7, 1, 10, 0))
                .endDate(LocalDateTime.of(2024, 9, 1, 10, 0))
                .build());

        save(Bookings.builder()
                .users(List.of(user1))
                .listing(Collections.singletonList(listing1))
                .status("Passive")
                .startDate(LocalDateTime.of(2024, 8, 1, 10, 0))
                .endDate(LocalDateTime.of(2024, 12, 3, 12, 0))
                .build());
    }
}
