package homework.service.impl;

import homework.dto.DtoMapperService;

import homework.dto.category.CategoryFullDto;
import homework.entity.Category;
import homework.repository.api.CategoryRepository;
import homework.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository repository;
    private final  DtoMapperService mapperService;

    @Override
    public List<CategoryFullDto> findAll() {
        return repository.findAll().stream()
                .map(category -> mapperService.convertToDto(category, CategoryFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryFullDto findById(long id) {
        Category category = repository.findById(id);
        return mapperService.convertToDto(category, CategoryFullDto.class);
    }

    @Override
    public void save(CategoryFullDto object) {
        Category category = mapperService.convertToEntity(object, Category.class);
        repository.save(category);
    }

    @Override
    public void update(long id, CategoryFullDto updateDTO) {
        Category category  = mapperService.convertToEntity(updateDTO, Category.class);
        repository.update(id, category);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);

    }
}
