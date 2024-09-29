package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.favoriteItem.FavoriteItemFullDto;
import homework.entity.FavoriteItem;
import homework.repository.api.FavoriteItemRepository;
import homework.service.FavoriteItemService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(
        classes = {AppConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
class FavoriteItemServiceImplTest {

    @InjectMocks
    private FavoriteItemServiceImpl favoriteItemService;

    @Spy
    private FavoriteItemRepository favoriteItemRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        FavoriteItem favoriteItem1 = new FavoriteItem(1L, null, null);
        FavoriteItem favoriteItem2 = new FavoriteItem(2L, null, null);

        when(favoriteItemRepository.findAll()).thenReturn(List.of(favoriteItem1, favoriteItem2));

        FavoriteItemFullDto dto1 = new FavoriteItemFullDto();
        FavoriteItemFullDto dto2 = new FavoriteItemFullDto();

        when(mapper.convertToDto(favoriteItem1, FavoriteItemFullDto.class)).thenReturn(dto1);
        when(mapper.convertToDto(favoriteItem2, FavoriteItemFullDto.class)).thenReturn(dto2);

        List<FavoriteItemFullDto> actual = favoriteItemService.findAll();

        verify(favoriteItemRepository, times(1)).findAll();
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
    }

    @Test
    void findById() {
        long id = 1L;
        FavoriteItem favoriteItem = new FavoriteItem(id, null, null);

        when(favoriteItemRepository.findById(id)).thenReturn(favoriteItem);

        FavoriteItemFullDto expectedDto = new FavoriteItemFullDto();

        when(mapper.convertToDto(favoriteItem, FavoriteItemFullDto.class)).thenReturn(expectedDto);

        FavoriteItemFullDto actual = favoriteItemService.findById(id);

        verify(favoriteItemRepository, times(1)).findById(id);
        assertNotNull(actual);
    }

    @Test
    void save() {
        FavoriteItemFullDto favoriteItemDto = new FavoriteItemFullDto();

        FavoriteItem favoriteItem = new FavoriteItem();

        when(mapper.convertToEntity(favoriteItemDto, FavoriteItem.class)).thenReturn(favoriteItem);

        doNothing().when(favoriteItemRepository).save(any(FavoriteItem.class));

        favoriteItemService.save(favoriteItemDto);

        verify(favoriteItemRepository, times(1)).save(favoriteItem);
    }

    @Test
    void update() {
        long id = 1L;
        FavoriteItemFullDto updateDto = new FavoriteItemFullDto();

        FavoriteItem existingItem = new FavoriteItem(id, null, null);
        FavoriteItem updatedItem = new FavoriteItem(id, null, null);

        when(favoriteItemRepository.findById(id)).thenReturn(existingItem);
        when(mapper.convertToEntity(updateDto, FavoriteItem.class)).thenReturn(updatedItem);

        doNothing().when(favoriteItemRepository).update(any(FavoriteItem.class));

        favoriteItemService.update(id, updateDto);

        verify(favoriteItemRepository, times(1)).update(updatedItem);
    }

    @Test
    void deleteById() {
        long id = 1L;

        favoriteItemService.deleteById(id);

        verify(favoriteItemRepository, times(1)).deleteById(id);
    }
}
