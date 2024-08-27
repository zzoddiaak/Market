package homework.repository.impl;

import homework.entity.FavoriteItem;
import homework.entity.Listing;
import homework.entity.User;
import homework.repository.AbstractRepository;
import homework.repository.api.FavoriteItemRepository;
import homework.repository.api.ListingRepository;
import homework.repository.api.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;

@Repository
public class FavoriteItemRepositoryImpl extends AbstractRepository<FavoriteItem> implements FavoriteItemRepository {

    private final UserRepository userRepository;
    private final ListingRepository listingRepository;

    @Autowired
    public FavoriteItemRepositoryImpl(UserRepository userRepository, ListingRepository listingRepository) {
        this.userRepository = userRepository;
        this.listingRepository = listingRepository;
        initializeData();
    }

    private void initializeData() {
        User user = userRepository.findById(1L);
        Listing listing = listingRepository.findById(1L);
        Listing listing1 = listingRepository.findById(2L);

        save(FavoriteItem.builder()
                .listing(Collections.singletonList(listing))
                .user(Collections.singletonList(user))
                .build());

        save(FavoriteItem.builder()
                .listing(Collections.singletonList(listing1))
                .user(Collections.singletonList(user))
                .build());
    }
}
