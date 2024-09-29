package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.listingRequest.ListingRequestFullDto;
import homework.entity.ListingRequest;
import homework.repository.api.ListingRequestRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
class ListingRequestServiceImplTest {

    @InjectMocks
    private ListingRequestServiceImpl listingRequestService;

    @Mock
    private ListingRequestRepository listingRequestRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        ListingRequest request1 = ListingRequest.builder()
                .id(1L)
                .status("Test 1")
                .build();
        ListingRequest request2 = ListingRequest.builder()
                .id(2L)
                .status("Test 2")
                .build();

        when(listingRequestRepository.findAll()).thenReturn(List.of(request1, request2));

        ListingRequestFullDto dto1 = new ListingRequestFullDto();
        dto1.setStatus("Test 1");
        ListingRequestFullDto dto2 = new ListingRequestFullDto();
        dto2.setStatus("Test 2");

        when(mapper.convertToDto(request1, ListingRequestFullDto.class)).thenReturn(dto1);
        when(mapper.convertToDto(request2, ListingRequestFullDto.class)).thenReturn(dto2);

        List<ListingRequestFullDto> actual = listingRequestService.findAll();

        verify(listingRequestRepository, times(1)).findAll();
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
    }

    @Test
    void findById() {
        long id = 1L;
        ListingRequest request = ListingRequest.builder()
                .id(id)
                .status("Test 1")
                .build();

        when(listingRequestRepository.findById(id)).thenReturn(request);

        ListingRequestFullDto expectedDto = new ListingRequestFullDto();
        expectedDto.setStatus("Test 1");

        when(mapper.convertToDto(request, ListingRequestFullDto.class)).thenReturn(expectedDto);

        ListingRequestFullDto actual = listingRequestService.findById(id);

        verify(listingRequestRepository, times(1)).findById(id);
        assertNotNull(actual);
        assertEquals(expectedDto.getStatus(), actual.getStatus());
    }

    @Test
    void save() {
        ListingRequestFullDto requestDto = new ListingRequestFullDto();
        requestDto.setStatus("Test 1");

        ListingRequest request = ListingRequest.builder()
                .status("Test 1")
                .build();

        when(mapper.convertToEntity(requestDto, ListingRequest.class)).thenReturn(request);

        doNothing().when(listingRequestRepository).save(any(ListingRequest.class));

        listingRequestService.save(requestDto);

        verify(listingRequestRepository, times(1)).save(request);
    }

    @Test
    void update() {
        long id = 1L;
        ListingRequestFullDto updateDto = new ListingRequestFullDto();
        updateDto.setStatus("Updated status");

        ListingRequest existingRequest = ListingRequest.builder()
                .id(id)
                .status("Test 1")
                .build();

        ListingRequest updatedRequest = ListingRequest.builder()
                .id(id)
                .status("Updated status")
                .build();

        when(listingRequestRepository.findById(id)).thenReturn(existingRequest);
        when(mapper.convertToEntity(updateDto, ListingRequest.class)).thenReturn(updatedRequest);

        doNothing().when(listingRequestRepository).update(any(ListingRequest.class));

        listingRequestService.update(id, updateDto);

        verify(listingRequestRepository, times(1)).update(updatedRequest);
    }

    @Test
    void deleteById() {
        long id = 1L;

        listingRequestService.deleteById(id);

        verify(listingRequestRepository, times(1)).deleteById(id);
    }
}
