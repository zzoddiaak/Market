package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.transaction.TransactionFullDto;
import homework.entity.Transaction;
import homework.repository.api.TransactionRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
class TransactionServiceImplTest {

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Spy
    private TransactionRepository transactionRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        Transaction transaction1 = Transaction.builder()
                .id(1L)
                .completedAt(LocalDate.now())
                .build();
        Transaction transaction2 = Transaction.builder()
                .id(2L)
                .completedAt(LocalDate.now())
                .build();

        when(transactionRepository.findAll()).thenReturn(List.of(transaction1, transaction2));

        TransactionFullDto dto1 = new TransactionFullDto();
        dto1.setCompletedAt(LocalDate.now());
        TransactionFullDto dto2 = new TransactionFullDto();
        dto2.setCompletedAt(LocalDate.now());

        when(mapper.convertToDto(transaction1, TransactionFullDto.class)).thenReturn(dto1);
        when(mapper.convertToDto(transaction2, TransactionFullDto.class)).thenReturn(dto2);

        List<TransactionFullDto> actual = transactionService.findAll();

        verify(transactionRepository, times(1)).findAll();
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
    }

    @Test
    void findById() {
        long id = 1L;
        Transaction transaction = Transaction.builder()
                .id(id)
                .completedAt(LocalDate.now())
                .build();

        when(transactionRepository.findById(id)).thenReturn(transaction);

        TransactionFullDto expectedDto = new TransactionFullDto();
        expectedDto.setCompletedAt(LocalDate.now());

        when(mapper.convertToDto(transaction, TransactionFullDto.class)).thenReturn(expectedDto);

        TransactionFullDto actual = transactionService.findById(id);

        verify(transactionRepository, times(1)).findById(id);
        assertNotNull(actual);
    }

    @Test
    void save() {
        TransactionFullDto transactionDto = new TransactionFullDto();
        transactionDto.setCompletedAt(LocalDate.now());

        Transaction transaction = Transaction.builder()
                .completedAt(LocalDate.now())
                .build();

        when(mapper.convertToEntity(transactionDto, Transaction.class)).thenReturn(transaction);

        doNothing().when(transactionRepository).save(any(Transaction.class));

        transactionService.save(transactionDto);

        verify(transactionRepository, times(1)).save(transaction);
    }

    @Test
    void update() {
        long id = 1L;
        TransactionFullDto updateDto = new TransactionFullDto();
        updateDto.setCompletedAt(LocalDate.now().plusDays(1));

        Transaction existingTransaction = Transaction.builder()
                .id(id)
                .completedAt(LocalDate.now())
                .build();

        Transaction updatedTransaction = Transaction.builder()
                .id(id)
                .completedAt(LocalDate.now().plusDays(1))
                .build();

        when(transactionRepository.findById(id)).thenReturn(existingTransaction);
        when(mapper.convertToEntity(updateDto, Transaction.class)).thenReturn(updatedTransaction);

        doNothing().when(transactionRepository).update(any(Transaction.class));

        transactionService.update(id, updateDto);

        verify(transactionRepository, times(1)).update(updatedTransaction);
    }

    @Test
    void deleteById() {
        long id = 1L;

        transactionService.deleteById(id);

        verify(transactionRepository, times(1)).deleteById(id);
    }
}
