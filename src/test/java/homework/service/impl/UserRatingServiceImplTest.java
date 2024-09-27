package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.userRating.UserRatingFullDto;
import homework.entity.UserRating;
import homework.repository.api.UserRatingRepository;
import homework.service.UserRatingService;
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
class UserRatingServiceImplTest {

    @InjectMocks
    private UserRatingServiceImpl userRatingService;

    @Spy
    private UserRatingRepository userRatingRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        UserRating rating1 = UserRating.builder()
                .id(1L)
                .rating(5)
                .build();
        UserRating rating2 = UserRating.builder()
                .id(2L)
                .rating(4)
                .build();

        when(userRatingRepository.findAll()).thenReturn(List.of(rating1, rating2));

        UserRatingFullDto dto1 = new UserRatingFullDto();
        dto1.setRating(5);
        UserRatingFullDto dto2 = new UserRatingFullDto();
        dto2.setRating(4);

        when(mapper.convertToDto(rating1, UserRatingFullDto.class)).thenReturn(dto1);
        when(mapper.convertToDto(rating2, UserRatingFullDto.class)).thenReturn(dto2);

        List<UserRatingFullDto> actual = userRatingService.findAll();

        verify(userRatingRepository, times(1)).findAll();
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        assertEquals(5, actual.get(0).getRating());
        assertEquals(4, actual.get(1).getRating());
    }

    @Test
    void findById() {
        long id = 1L;
        UserRating rating = UserRating.builder()
                .id(id)
                .rating(5)
                .build();

        when(userRatingRepository.findById(id)).thenReturn(rating);

        UserRatingFullDto expectedDto = new UserRatingFullDto();
        expectedDto.setRating(5);

        when(mapper.convertToDto(rating, UserRatingFullDto.class)).thenReturn(expectedDto);

        UserRatingFullDto actual = userRatingService.findById(id);

        verify(userRatingRepository, times(1)).findById(id);
        assertNotNull(actual);
        assertEquals(expectedDto.getRating(), actual.getRating());
    }

    @Test
    void save() {
        UserRatingFullDto ratingDto = new UserRatingFullDto();
        ratingDto.setRating(5);

        UserRating rating = UserRating.builder()
                .rating(5)
                .build();

        when(mapper.convertToEntity(ratingDto, UserRating.class)).thenReturn(rating);

        doNothing().when(userRatingRepository).save(any(UserRating.class));

        userRatingService.save(ratingDto);

        verify(userRatingRepository, times(1)).save(rating);
    }

    @Test
    void update() {
        long id = 1L;
        UserRatingFullDto updateDto = new UserRatingFullDto();
        updateDto.setRating(4);

        UserRating existingRating = UserRating.builder()
                .id(id)
                .rating(5)
                .build();

        UserRating updatedRating = UserRating.builder()
                .id(id)
                .rating(4)
                .build();

        when(userRatingRepository.findById(id)).thenReturn(existingRating);
        when(mapper.convertToEntity(updateDto, UserRating.class)).thenReturn(updatedRating);

        doNothing().when(userRatingRepository).update(any(UserRating.class));

        userRatingService.update(id, updateDto);

        verify(userRatingRepository, times(1)).update(updatedRating);
    }

    @Test
    void deleteById() {
        long id = 1L;

        userRatingService.deleteById(id);

        verify(userRatingRepository, times(1)).deleteById(id);
    }
}
