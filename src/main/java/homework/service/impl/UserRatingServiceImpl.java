package homework.service.impl;

import homework.dto.DtoMapperService;
import homework.dto.userRating.UserRatingFullDto;
import homework.entity.UserRating;
import homework.repository.api.UserRatingRepository;
import homework.service.UserRatingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserRatingServiceImpl implements UserRatingService {
    private final UserRatingRepository repository;
    private final DtoMapperService mapperService;

    @Override
    public List<UserRatingFullDto> findAll() {
        return repository.findAll().stream()
                .map(userRating -> mapperService.convertToDto(userRating, UserRatingFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserRatingFullDto findById(long id) {
        UserRating userRating = repository.findById(id);
        return mapperService.convertToDto(userRating, UserRatingFullDto.class);
    }

    @Override
    public void save(UserRatingFullDto object) {
        UserRating userRating = mapperService.convertToEntity(object, UserRating.class);
        repository.save(userRating);
    }

    @Override
    public void update(long id, UserRatingFullDto updateDTO) {
        UserRating userRating = mapperService.convertToEntity(updateDTO, UserRating.class);
        repository.update(id, userRating);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
