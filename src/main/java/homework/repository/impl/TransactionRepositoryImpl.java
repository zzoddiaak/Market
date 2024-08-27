package homework.repository.impl;

import homework.entity.ListingRequest;
import homework.entity.Transaction;
import homework.repository.AbstractRepository;
import homework.repository.api.ListingRequestRepository;
import homework.repository.api.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class TransactionRepositoryImpl extends AbstractRepository<Transaction> implements TransactionRepository {

    private final ListingRequestRepository listingRequestRepository;

    @Autowired
    public TransactionRepositoryImpl(ListingRequestRepository listingRequestRepository) {
        this.listingRequestRepository = listingRequestRepository;
        initializeData();
    }

    private void initializeData() {
        ListingRequest listingRequest = listingRequestRepository.findById(1L);
        ListingRequest listingRequest1 = listingRequestRepository.findById(2L);

        if (listingRequest != null) {
            save(Transaction.builder()
                    .completedAt(LocalDate.of(2024, 7, 1))
                    .request(listingRequest)
                    .build());
        }

        if (listingRequest1 != null) {
            save(Transaction.builder()
                    .completedAt(LocalDate.of(2024, 8, 1))  // Исправлена дата на корректную
                    .request(listingRequest1)
                    .build());
        }
    }
}
