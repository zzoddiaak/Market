package homework.repository.impl;

import homework.entity.ListingRequest;
import homework.entity.Transaction;
import homework.repository.AbstractRepository;
import homework.repository.api.ListingRequestRepository;
import homework.repository.api.TransactionRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Repository;


@Repository
public class TransactionRepositoryImpl extends AbstractRepository<Transaction> implements TransactionRepository {

    ListingRequestRepository listingRequestRepository;

    public TransactionRepositoryImpl() {

    this.listingRequestRepository = new ListingRequestRepositoryImpl();
    initializeData();

    }
    private void initializeData(){

        ListingRequest listingRequest = listingRequestRepository.findById(1L);
        ListingRequest listingRequest1 = listingRequestRepository.findById(2L);


        save(Transaction.builder()
                .completedAt(LocalDate.of(2024, 7, 1))
                .request(listingRequest)
                .build());

        save(Transaction.builder()
                .completedAt(LocalDate.of(2024, 13, 1))
                .request(listingRequest1)
                .build());

    }
}
