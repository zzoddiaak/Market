package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.user.UserFullDto;
import homework.entity.User;
import homework.repository.api.UserRepository;
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

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Spy
    private UserRepository userRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        User user1 = User.builder()
                .id(1L)
                .firstName("John")
                .lastName("Doe")
                .bio("Bio of John Doe")
                .createdAt(LocalDateTime.now())
                .build();

        User user2 = User.builder()
                .id(2L)
                .firstName("Jane")
                .lastName("Doe")
                .bio("Bio of Jane Doe")
                .createdAt(LocalDateTime.now())
                .build();

        when(userRepository.findAll()).thenReturn(List.of(user1, user2));

        UserFullDto dto1 = new UserFullDto();
        dto1.setFirstName("John");

        UserFullDto dto2 = new UserFullDto();
        dto2.setFirstName("Jane");

        when(mapper.convertToDto(user1, UserFullDto.class)).thenReturn(dto1);
        when(mapper.convertToDto(user2, UserFullDto.class)).thenReturn(dto2);

        List<UserFullDto> actual = userService.findAll();
        verify(userRepository, times(1)).findAll();
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        assertEquals("John", actual.get(0).getFirstName());
        assertEquals("Jane", actual.get(1).getFirstName());
    }

    @Test
    void findById() {
        long id = 1L;
        User user = User.builder()
                .id(id)
                .firstName("John")
                .lastName("Doe")
                .bio("Bio of John Doe")
                .createdAt(LocalDateTime.now())
                .build();

        when(userRepository.findById(id)).thenReturn(user);
        UserFullDto expectedDto = new UserFullDto();
        expectedDto.setFirstName("John");
        when(mapper.convertToDto(user, UserFullDto.class)).thenReturn(expectedDto);
        UserFullDto actual = userService.findById(id);
        verify(userRepository, times(1)).findById(id);
        assertNotNull(actual);
        assertEquals(expectedDto.getFirstName(), actual.getFirstName());
    }

    @Test
    void save() {
        UserFullDto userDto = new UserFullDto();
        userDto.setFirstName("John");

        User user = User.builder()
                .firstName("John")
                .lastName("Doe")
                .bio("Bio of John Doe")
                .createdAt(LocalDateTime.now())
                .build();

        when(mapper.convertToEntity(userDto, User.class)).thenReturn(user);
        doNothing().when(userRepository).save(any(User.class));
        userService.save(userDto);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    void update() {
        long id = 1L;
        UserFullDto updateDto = new UserFullDto();
        updateDto.setFirstName("Updated John");

        User existingUser = User.builder()
                .id(id)
                .firstName("John")
                .lastName("Doe")
                .bio("Bio of John Doe")
                .createdAt(LocalDateTime.now())
                .build();

        User updatedUser = User.builder()
                .id(id)
                .firstName("Updated John")
                .lastName("Doe")
                .bio("Updated bio")
                .createdAt(LocalDateTime.now())
                .build();

        when(userRepository.findById(id)).thenReturn(existingUser);
        when(mapper.convertToEntity(updateDto, User.class)).thenReturn(updatedUser);
        doNothing().when(userRepository).update(any(User.class));
        userService.update(id, updateDto);
        verify(userRepository, times(1)).update(updatedUser);
    }

    @Test
    void deleteById() {
        long id = 1L;
        userService.deleteById(id);
        verify(userRepository, times(1)).deleteById(id);
    }
}
