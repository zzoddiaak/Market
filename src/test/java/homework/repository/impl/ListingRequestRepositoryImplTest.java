package homework.repository.impl;

import homework.config.TestConfig;
import homework.entity.ListingRequest;
import homework.repository.api.ListingRequestRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class ListingRequestRepositoryImplTest {

    @Resource
    private ListingRequestRepository listingRequestRepository;

    @Before
    public void setUp() {
        ListingRequest listingRequest1 = ListingRequest.builder()
                .offeredPrice(new BigDecimal("500.00"))
                .status("Pending")
                .createdAt(LocalDateTime.now())
                .build();

        ListingRequest listingRequest2 = ListingRequest.builder()
                .offeredPrice(new BigDecimal("1500.00"))
                .status("Approved")
                .createdAt(LocalDateTime.now())
                .build();

        listingRequestRepository.save(listingRequest1);
        listingRequestRepository.save(listingRequest2);
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
