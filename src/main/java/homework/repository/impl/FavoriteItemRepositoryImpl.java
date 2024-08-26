package homework.repository.impl;

import homework.entity.FavoriteItem;
import homework.entity.Listing;
import homework.entity.User;
import homework.repository.AbstractRepository;
import homework.repository.api.FavoriteItemRepository;
import homework.repository.api.ListingRepository;
import homework.repository.api.UserRepository;
import java.util.List;
import org.springframework.stereotype.Repository;


@Repository
public class FavoriteItemRepositoryImpl extends AbstractRepository<FavoriteItem> implements FavoriteItemRepository {
    private UserRepository userRepository;
    private ListingRepository listingRepository;

    public FavoriteItemRepositoryImpl() {
        userRepository = new UserRepositoryImpl();
        listingRepository = new ListingRepositoryImpl();
        initializeData();
    }
    private void initializeData(){
        List<User> user = (List<User>) userRepository.findById(1L);
        List<Listing> listing = (List<Listing>) listingRepository.findById(1L);
        List<Listing> listing1 = (List<Listing>) listingRepository.findById(2L);

        save(FavoriteItem.builder()
                .listing(listing)
                .user(user)
                .build());

        save(FavoriteItem.builder()
                .listing(listing1)
                .user(user)
                .build());
    }

    }
