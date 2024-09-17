package homework.repository.impl;

import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.Transaction;
import homework.repository.api.TransactionRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class, LiquibaseConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class TransactionRepositoryImplTest {

    @Resource
    private TransactionRepository transactionRepository;

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
