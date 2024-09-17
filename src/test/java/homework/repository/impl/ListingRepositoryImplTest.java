package homework.repository.impl;

import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.Listing;
import homework.repository.api.ListingRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class, LiquibaseConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class ListingRepositoryImplTest {

    @Resource
    private ListingRepository listingRepository;

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
