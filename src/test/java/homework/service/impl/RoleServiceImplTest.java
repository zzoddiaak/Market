package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.role.RoleFullDto;
import homework.entity.Role;
import homework.repository.api.RoleRepository;
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
class RoleServiceImplTest {

    @InjectMocks
    private RoleServiceImpl roleService;

    @Spy
    private RoleRepository roleRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        Role role1 = Role.builder()
                .id(1L)
                .name("ROLE_USER")
                .build();
        Role role2 = Role.builder()
                .id(2L)
                .name("ROLE_ADMIN")
                .build();

        when(roleRepository.findAll()).thenReturn(List.of(role1, role2));

        RoleFullDto dto1 = new RoleFullDto();
        dto1.setName("ROLE_USER");
        RoleFullDto dto2 = new RoleFullDto();
        dto2.setName("ROLE_ADMIN");

        when(mapper.convertToDto(role1, RoleFullDto.class)).thenReturn(dto1);
        when(mapper.convertToDto(role2, RoleFullDto.class)).thenReturn(dto2);

        List<RoleFullDto> actual = roleService.findAll();

        verify(roleRepository, times(1)).findAll();
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
    }

    @Test
    void findById() {
        long id = 1L;
        Role role = Role.builder()
                .id(id)
                .name("ROLE_USER")
                .build();

        when(roleRepository.findById(id)).thenReturn(role);

        RoleFullDto expectedDto = new RoleFullDto();
        expectedDto.setName("ROLE_USER");

        when(mapper.convertToDto(role, RoleFullDto.class)).thenReturn(expectedDto);

        RoleFullDto actual = roleService.findById(id);

        verify(roleRepository, times(1)).findById(id);
        assertNotNull(actual);
        assertEquals(expectedDto.getName(), actual.getName());
    }

    @Test
    void save() {
        RoleFullDto roleDto = new RoleFullDto();
        roleDto.setName("ROLE_USER");

        Role role = Role.builder()
                .name("ROLE_USER")
                .build();

        when(mapper.convertToEntity(roleDto, Role.class)).thenReturn(role);

        doNothing().when(roleRepository).save(any(Role.class));

        roleService.save(roleDto);

        verify(roleRepository, times(1)).save(role);
    }

    @Test
    void update() {
        long id = 1L;
        RoleFullDto updateDto = new RoleFullDto();
        updateDto.setName("ROLE_ADMIN");

        Role existingRole = Role.builder()
                .id(id)
                .name("ROLE_USER")
                .build();

        Role updatedRole = Role.builder()
                .id(id)
                .name("ROLE_ADMIN")
                .build();

        when(roleRepository.findById(id)).thenReturn(existingRole);
        when(mapper.convertToEntity(updateDto, Role.class)).thenReturn(updatedRole);

        doNothing().when(roleRepository).update(any(Role.class));

        roleService.update(id, updateDto);

        verify(roleRepository, times(1)).update(updatedRole);
    }

    @Test
    void deleteById() {
        long id = 1L;

        roleService.deleteById(id);

        verify(roleRepository, times(1)).deleteById(id);
    }
}
