package homework.dto;


import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DtoMapperService {
    private ModelMapper modelMapper;

    @Autowired
    public DtoMapperService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public  <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }


}
