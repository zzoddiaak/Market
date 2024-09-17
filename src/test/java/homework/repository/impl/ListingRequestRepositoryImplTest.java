package homework.repository.impl;

import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.ListingRequest;
import homework.repository.api.ListingRequestRepository;
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
public class ListingRequestRepositoryImplTest {

    @Resource
    private ListingRequestRepository listingRequestRepository;

    @Test
    public void findAllWithAssociationsCriteria() {
        List<ListingRequest> listingRequests = listingRequestRepository.findAllWithAssociationsCriteria();
        assertNotNull(listingRequests);
        assertFalse(listingRequests.isEmpty());
    }

    @Test
    public void findAllWithAssociationsJPQL() {
        List<ListingRequest> listingRequests = listingRequestRepository.findAllWithAssociationsJPQL();
        assertNotNull(listingRequests);
        assertFalse(listingRequests.isEmpty());
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<ListingRequest> listingRequests = listingRequestRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(listingRequests);
        assertFalse(listingRequests.isEmpty());
    }

    @Test
    public void findByOfferedPriceCriteria() {
        BigDecimal offeredPrice = new BigDecimal("500.00");
        List<ListingRequest> listingRequests = listingRequestRepository.findByOfferedPriceCriteria(offeredPrice);
        assertNotNull(listingRequests);
        assertFalse(listingRequests.isEmpty());
    }
}
