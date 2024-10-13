package homework.service.impl;

import homework.dto.DtoMapper;
import homework.dto.role.RoleFullDto;
import homework.entity.Role;
import homework.exeption.RoleNotFoundException;
import homework.repository.api.RoleRepository;
import homework.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final DtoMapper mapper;

    @Override
    public List<RoleFullDto> findAll() {
        return repository.findAll().stream()
                .map(role -> mapper.convertToDto(role, RoleFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleFullDto findById(long id) {
        Role role = repository.findById(id);
        return mapper.convertToDto(role, RoleFullDto.class);
    }

    @Override
    public void save(RoleFullDto object) {
        Role role = mapper.convertToEntity(object, Role.class);
        repository.save(role);
    }

    @Override
    public void update(long id, RoleFullDto updateDTO) {
        Role role = mapper.convertToEntity(updateDTO, Role.class);
        repository.update(role);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }

    @Override
    public RoleFullDto findByRoleName(String roleName) {
        List<Role> roles = repository.findByRoleName(roleName);


        Role role = roles.get(0);
        return mapper.convertToDto(role, RoleFullDto.class);
    }

}
