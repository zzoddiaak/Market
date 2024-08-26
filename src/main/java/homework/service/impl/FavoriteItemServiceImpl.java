package homework.service.impl;

import homework.dto.DtoMapperService;
import homework.dto.favoriteItem.FavoriteItemFullDto;
import homework.entity.FavoriteItem;
import homework.repository.api.FavoriteItemRepository;
import homework.service.FavoriteItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoriteItemServiceImpl implements FavoriteItemService {
    private final FavoriteItemRepository repository;
    private final DtoMapperService mapperService;

    @Override
    public List<FavoriteItemFullDto> findAll() {
        return repository.findAll().stream()
                .map(favoriteItem -> mapperService.convertToDto(favoriteItem, FavoriteItemFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public FavoriteItemFullDto findById(long id) {
        FavoriteItem favoriteItem = repository.findById(id);
        return mapperService.convertToDto(favoriteItem, FavoriteItemFullDto.class);
    }

    @Override
    public void save(FavoriteItemFullDto object) {
        FavoriteItem favoriteItem = mapperService.convertToEntity(object, FavoriteItem.class);
        repository.save(favoriteItem);
    }

    @Override
    public void update(long id, FavoriteItemFullDto updateDTO) {
        FavoriteItem favoriteItem = mapperService.convertToEntity(updateDTO, FavoriteItem.class);
        repository.update(id, favoriteItem);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
