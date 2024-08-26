package homework.service.impl;

import homework.dto.DtoMapperService;
import homework.dto.userCredential.UserCredentialFullDto;
import homework.entity.UserCredential;
import homework.repository.api.UserCredentialRepository;
import homework.service.UserCredentialService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCredentialServiceImpl implements UserCredentialService {
    private final UserCredentialRepository repository;
    private final DtoMapperService mapperService;

    @Override
    public List<UserCredentialFullDto> findAll() {
        return repository.findAll().stream()
                .map(userCredential -> mapperService.convertToDto(userCredential, UserCredentialFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserCredentialFullDto findById(long id) {
        UserCredential userCredential = repository.findById(id);
        return mapperService.convertToDto(userCredential, UserCredentialFullDto.class);
    }

    @Override
    public void save(UserCredentialFullDto object) {
        UserCredential userCredential = mapperService.convertToEntity(object, UserCredential.class);
        repository.save(userCredential);
    }

    @Override
    public void update(long id, UserCredentialFullDto updateDTO) {
        UserCredential userCredential = mapperService.convertToEntity(updateDTO, UserCredential.class);
        repository.update(id, userCredential);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}