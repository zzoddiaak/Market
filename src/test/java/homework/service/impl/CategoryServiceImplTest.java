package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.category.CategoryFullDto;
import homework.entity.Category;
import homework.repository.api.CategoryRepository;
import homework.service.CategoryService;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(
        classes = {AppConfig.class},
        loader = AnnotationConfigContextLoader.class
)
@Transactional
class CategoryServiceImplTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Spy
    private CategoryRepository categoryRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        Category category1 = new Category(1L, "Electronics");
        Category category2 = new Category(2L, "Books");

        when(categoryRepository.findAll()).thenReturn(List.of(category1, category2));

        CategoryFullDto dto1 = new CategoryFullDto();
        dto1.setName("Electronics");
        CategoryFullDto dto2 = new CategoryFullDto();
        dto2.setName("Books");

        when(mapper.convertToDto(category1, CategoryFullDto.class)).thenReturn(dto1);
        when(mapper.convertToDto(category2, CategoryFullDto.class)).thenReturn(dto2);

        List<CategoryFullDto> actual = categoryService.findAll();

        verify(categoryRepository, times(1)).findAll();
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        assertEquals("Electronics", actual.get(0).getName());
        assertEquals("Books", actual.get(1).getName());
    }

    @Test
    void findById() {
        long id = 1L;
        Category category = new Category(id, "Electronics");

        when(categoryRepository.findById(id)).thenReturn(category);

        CategoryFullDto expectedDto = new CategoryFullDto();
        expectedDto.setName("Electronics");

        when(mapper.convertToDto(category, CategoryFullDto.class)).thenReturn(expectedDto);

        CategoryFullDto actual = categoryService.findById(id);

        verify(categoryRepository, times(1)).findById(id);
        assertNotNull(actual);
        assertEquals(expectedDto.getName(), actual.getName());
    }

    @Test
    void save() {
        CategoryFullDto categoryDto = new CategoryFullDto();
        categoryDto.setName("Electronics");

        Category category = new Category();
        category.setName("Electronics");

        when(mapper.convertToEntity(categoryDto, Category.class)).thenReturn(category);

        doNothing().when(categoryRepository).save(any(Category.class));

        categoryService.save(categoryDto);

        verify(categoryRepository, times(1)).save(category);
    }

    @Test
    void update() {
        long id = 1L;
        CategoryFullDto updateDto = new CategoryFullDto();
        updateDto.setName("Updated Category");

        Category existingCategory = new Category(id, "Electronics");
        Category updatedCategory = new Category(id, "Updated Category");

        when(categoryRepository.findById(id)).thenReturn(existingCategory);
        when(mapper.convertToEntity(updateDto, Category.class)).thenReturn(updatedCategory);

        doNothing().when(categoryRepository).update(any(Category.class));

        categoryService.update(id, updateDto);

        verify(categoryRepository, times(1)).update(updatedCategory);
    }

    @Test
    void deleteById() {
        long id = 1L;

        categoryService.deleteById(id);

        verify(categoryRepository, times(1)).deleteById(id);
    }
}
