package homework.dto;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoMapper {

    private final ModelMapper modelMapper;

    public DtoMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        try {

            return modelMapper.map(entity, dtoClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to map entity to DTO", e);
        }
    }

    public <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        try {

            return modelMapper.map(dto, entityClass);
        } catch (Exception e) {
            throw new RuntimeException("Failed to map DTO to entity", e);
        }
    }
}
