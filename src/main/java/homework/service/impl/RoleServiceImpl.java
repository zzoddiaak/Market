package homework.service.impl;

import homework.dto.DtoMapperService;
import homework.dto.role.RoleFullDto;
import homework.entity.Role;
import homework.repository.api.RoleRepository;
import homework.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepository repository;
    private final DtoMapperService mapperService;

    @Override
    public List<RoleFullDto> findAll() {
        return repository.findAll().stream()
                .map(role -> mapperService.convertToDto(role, RoleFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public RoleFullDto findById(long id) {
        Role role = repository.findById(id);
        return mapperService.convertToDto(role, RoleFullDto.class);
    }

    @Override
    public void save(RoleFullDto object) {
        Role role = mapperService.convertToEntity(object, Role.class);
        repository.save(role);
    }

    @Override
    public void update(long id, RoleFullDto updateDTO) {
        Role role = mapperService.convertToEntity(updateDTO, Role.class);
        repository.update(id, role);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}