package homework.repository.impl;

import homework.config.TestConfig;
import homework.entity.ListingRequest;
import homework.entity.Transaction;
import homework.repository.api.TransactionRepository;
import homework.repository.api.ListingRequestRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class TransactionRepositoryImplTest {

    @Resource
    private TransactionRepository transactionRepository;

    @Resource
    private ListingRequestRepository listingRequestRepository;

    @Before
    public void setUp() {
        ListingRequest listingRequest = ListingRequest.builder()
                .offeredPrice(BigDecimal.valueOf(1000))
                .status("Pending")
                .createdAt(LocalDateTime.now())
                .build();
        listingRequestRepository.save(listingRequest);

        Transaction transaction = Transaction.builder()
                .completedAt(LocalDate.now())
                .request(listingRequest)
                .build();
        transactionRepository.save(transaction);
    }

    @Test
    public void findAllWithAssociationsCriteria() {
        List<Transaction> transactions = transactionRepository.findAllWithAssociationsCriteria();
        assertNotNull(transactions);
        assertFalse(transactions.isEmpty());
    }

    @Test
    public void findAllWithAssociationsJPQL() {
        List<Transaction> transactions = transactionRepository.findAllWithAssociationsJPQL();
        assertNotNull(transactions);
        assertFalse(transactions.isEmpty());
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<Transaction> transactions = transactionRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(transactions);
        assertFalse(transactions.isEmpty());
    }

    @Test
    public void findByCompletedAtCriteria() {
        LocalDate completedAt = LocalDate.now();
        List<Transaction> transactions = transactionRepository.findByCompletedAtCriteria(completedAt);
        assertNotNull(transactions);
        assertFalse(transactions.isEmpty());
    }
}
