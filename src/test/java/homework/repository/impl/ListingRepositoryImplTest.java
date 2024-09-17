package homework.repository.impl;

import homework.config.TestConfig;
import homework.entity.Category;
import homework.entity.Listing;
import homework.repository.api.CategoryRepository;
import homework.repository.api.ListingRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class ListingRepositoryImplTest {

    @Resource
    private ListingRepository listingRepository;

    @Resource
    private CategoryRepository categoryRepository;

    @Before
    public void setUp() {
        Category category1 = Category.builder()
                .name("Category 1")
                .build();

        Category category2 = Category.builder()
                .name("Category 2")
                .build();

        categoryRepository.save(category1);
        categoryRepository.save(category2);

        Listing listing1 = Listing.builder()
                .title("Listing 1")
                .description("Description for Listing 1")
                .price(new BigDecimal("1000.00"))
                .negotiable(true)
                .listingType("Type1")
                .itemType("ItemType1")
                .address("Address 1")
                .rentalPrice(new BigDecimal("500.00"))
                .createdAt(LocalDateTime.now())
                .categories(Arrays.asList(category1, category2))
                .build();

        Listing listing2 = Listing.builder()
                .title("Listing 2")
                .description("Description for Listing 2")
                .price(new BigDecimal("2000.00"))
                .negotiable(false)
                .listingType("Type2")
                .itemType("ItemType2")
                .address("Address 2")
                .rentalPrice(new BigDecimal("700.00"))
                .createdAt(LocalDateTime.now())
                .categories(Arrays.asList(category1))
                .build();

        listingRepository.save(listing1);
        listingRepository.save(listing2);
    }

    @Test
    public void findAllWithAssociationsCriteria() {
        List<Listing> listings = listingRepository.findAllWithAssociationsCriteria();
        assertNotNull(listings);
        assertFalse(listings.isEmpty());
    }

    @Test
    public void findAllWithAssociationsJPQL() {
        List<Listing> listings = listingRepository.findAllWithAssociationsJPQL();
        assertNotNull(listings);
        assertFalse(listings.isEmpty());
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<Listing> listings = listingRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(listings);
        assertFalse(listings.isEmpty());
    }

    @Test
    public void findByPriceCriteria() {
        BigDecimal price = new BigDecimal("1000.00");
        List<Listing> listings = listingRepository.findByPriceCriteria(price);
        assertNotNull(listings);
        assertFalse(listings.isEmpty());
    }
}
