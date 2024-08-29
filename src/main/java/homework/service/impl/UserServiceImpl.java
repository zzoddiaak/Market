package homework.service.impl;

import homework.dto.DtoMapper;
import homework.dto.user.UserFullDto;
import homework.entity.User;
import homework.repository.api.UserRepository;
import homework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final DtoMapper mapper;

    @Override
    public List<UserFullDto> findAll() {
        return repository.findAll().stream()
                .map(user -> mapper.convertToDto(user, UserFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserFullDto findById(long id) {
        User user = repository.findById(id);
        return mapper.convertToDto(user, UserFullDto.class);
    }

    @Override
    public void save(UserFullDto object) {
        User user = mapper.convertToEntity(object, User.class);
        repository.save(user);
    }

    @Override
    public void update(long id, UserFullDto updateDTO) {
        User user = mapper.convertToEntity(updateDTO, User.class);
        repository.update(id, user);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
