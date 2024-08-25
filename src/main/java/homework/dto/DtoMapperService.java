package homework.dto;

import homework.dto.booking.BookingFullDto;
import homework.dto.category.CategoryFullDto;
import homework.dto.comment.CommentFullDto;
import homework.dto.favoriteItem.FavoriteItemFullDto;
import homework.dto.user.UserFullDto;
import homework.entity.Bookings;
import homework.entity.Category;
import homework.entity.Comment;
import homework.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class DtoMapperService {
    private ModelMapper modelMapper;

    public <D, E> D convertToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public <D, E> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }


}
