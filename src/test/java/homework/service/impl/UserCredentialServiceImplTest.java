package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.userCredential.UserCredentialFullDto;
import homework.entity.UserCredential;
import homework.repository.api.UserCredentialRepository;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(classes = {AppConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
class UserCredentialServiceImplTest {

    @InjectMocks
    private UserCredentialServiceImpl userCredentialService;

    @Spy
    private UserCredentialRepository userCredentialRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findById() {
        long id = 1L;
        UserCredential credential = UserCredential.builder()
                .id(id)
                .username("test_user")
                .password("password")
                .build();

        when(userCredentialRepository.findById(id)).thenReturn(credential);

        UserCredentialFullDto expectedDto = new UserCredentialFullDto();
        expectedDto.setUsername("test_user");

        when(mapper.convertToDto(credential, UserCredentialFullDto.class)).thenReturn(expectedDto);

        UserCredentialFullDto actual = userCredentialService.findById(id);

        verify(userCredentialRepository, times(1)).findById(id);
        assertNotNull(actual);
        assertEquals(expectedDto.getUsername(), actual.getUsername());
    }

    @Test
    void save() {
        UserCredentialFullDto credentialDto = new UserCredentialFullDto();
        credentialDto.setUsername("test_user");
        credentialDto.setPassword("password");

        UserCredential credential = UserCredential.builder()
                .username("test_user")
                .password("password")
                .build();

        when(mapper.convertToEntity(credentialDto, UserCredential.class)).thenReturn(credential);

        doNothing().when(userCredentialRepository).save(any(UserCredential.class));

        userCredentialService.save(credentialDto);

        verify(userCredentialRepository, times(1)).save(credential);
    }

    @Test
    void update() {
        long id = 1L;
        UserCredentialFullDto updateDto = new UserCredentialFullDto();
        updateDto.setUsername("updated_user");

        UserCredential existingCredential = UserCredential.builder()
                .id(id)
                .username("test_user")
                .build();

        UserCredential updatedCredential = UserCredential.builder()
                .id(id)
                .username("updated_user")
                .build();

        when(userCredentialRepository.findById(id)).thenReturn(existingCredential);
        when(mapper.convertToEntity(updateDto, UserCredential.class)).thenReturn(updatedCredential);

        doNothing().when(userCredentialRepository).update(any(UserCredential.class));

        userCredentialService.update(id, updateDto);

        verify(userCredentialRepository, times(1)).update(updatedCredential);
    }

    @Test
    void deleteById() {
        long id = 1L;

        userCredentialService.deleteById(id);

        verify(userCredentialRepository, times(1)).deleteById(id);
    }
}
