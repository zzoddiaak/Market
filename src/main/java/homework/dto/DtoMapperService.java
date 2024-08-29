package homework.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoMapperService {

    private final ModelMapper modelMapper;
    private final ObjectMapper objectMapper;

    public DtoMapperService(ModelMapper modelMapper, ObjectMapper objectMapper) {
        this.modelMapper = modelMapper;
        this.objectMapper = objectMapper;
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

    public String convertToJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException("Failed to convert object to JSON", e);
        }
    }

    public <T> T convertFromJson(String json, Class<T> valueType) {
        try {
            return objectMapper.readValue(json, valueType);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JSON", e);
        }
    }
}
