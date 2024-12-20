package homework.service.impl;

import homework.dto.DtoMapper;
import homework.dto.favoriteItem.FavoriteItemFullDto;
import homework.entity.FavoriteItem;
import homework.repository.api.FavoriteItemRepository;
import homework.service.FavoriteItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class FavoriteItemServiceImpl implements FavoriteItemService {

    private final FavoriteItemRepository repository;
    private final DtoMapper mapper;

    @Override
    public List<FavoriteItemFullDto> findAll() {

        return repository.findAll().stream()
                .map(favoriteItem -> mapper.convertToDto(favoriteItem, FavoriteItemFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FavoriteItemFullDto findById(long id) {
        FavoriteItem favoriteItem = repository.findById(id);

        return mapper.convertToDto(favoriteItem, FavoriteItemFullDto.class);
    }

    @Override
    public void save(FavoriteItemFullDto object) {
        FavoriteItem favoriteItem = mapper.convertToEntity(object, FavoriteItem.class);
        repository.save(favoriteItem);
    }

    @Override
    public void update(long id, FavoriteItemFullDto updateDTO) {
        FavoriteItem favoriteItem  = mapper.convertToEntity(updateDTO, FavoriteItem.class);
        repository.update(favoriteItem);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
