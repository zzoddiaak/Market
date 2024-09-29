package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.listing.ListingFullDto;
import homework.entity.Listing;
import homework.repository.api.ListingRepository;
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

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
class ListingServiceImplTest {

    @InjectMocks
    private ListingServiceImpl listingService;

    @Spy
    private ListingRepository listingRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        Listing listing1 = Listing.builder()
                .id(1L)
                .title("Listing 1")
                .build();
        Listing listing2 = Listing.builder()
                .id(2L)
                .title("Listing 2")
                .build();

        when(listingRepository.findAll()).thenReturn(List.of(listing1, listing2));

        ListingFullDto dto1 = new ListingFullDto();
        dto1.setTitle("Listing 1");
        ListingFullDto dto2 = new ListingFullDto();
        dto2.setTitle("Listing 2");

        when(mapper.convertToDto(listing1, ListingFullDto.class)).thenReturn(dto1);
        when(mapper.convertToDto(listing2, ListingFullDto.class)).thenReturn(dto2);

        List<ListingFullDto> actual = listingService.findAll();

        verify(listingRepository, times(1)).findAll();
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
    }

    @Test
    void findById() {
        long id = 1L;
        Listing listing = Listing.builder()
                .id(id)
                .title("Listing 1")
                .build();

        when(listingRepository.findById(id)).thenReturn(listing);

        ListingFullDto expectedDto = new ListingFullDto();
        expectedDto.setTitle("Listing 1");

        when(mapper.convertToDto(listing, ListingFullDto.class)).thenReturn(expectedDto);

        ListingFullDto actual = listingService.findById(id);

        verify(listingRepository, times(1)).findById(id);
        assertNotNull(actual);
        assertEquals(expectedDto.getTitle(), actual.getTitle());
    }

    @Test
    void save() {
        ListingFullDto listingDto = new ListingFullDto();
        listingDto.setTitle("Listing 1");

        Listing listing = Listing.builder()
                .title("Listing 1")
                .build();

        when(mapper.convertToEntity(listingDto, Listing.class)).thenReturn(listing);

        doNothing().when(listingRepository).save(any(Listing.class));

        listingService.save(listingDto);

        verify(listingRepository, times(1)).save(listing);
    }

    @Test
    void update() {
        long id = 1L;
        ListingFullDto updateDto = new ListingFullDto();
        updateDto.setTitle("Updated listing");

        Listing existingListing = Listing.builder()
                .id(id)
                .title("Listing 1")
                .build();

        Listing updatedListing = Listing.builder()
                .id(id)
                .title("Updated listing")
                .build();

        when(listingRepository.findById(id)).thenReturn(existingListing);
        when(mapper.convertToEntity(updateDto, Listing.class)).thenReturn(updatedListing);

        doNothing().when(listingRepository).update(any(Listing.class));

        listingService.update(id, updateDto);

        verify(listingRepository, times(1)).update(updatedListing);
    }

    @Test
    void deleteById() {
        long id = 1L;

        listingService.deleteById(id);

        verify(listingRepository, times(1)).deleteById(id);
    }
}
