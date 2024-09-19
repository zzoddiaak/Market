package homework.service;

import homework.dto.comment.CommentFullDto;

import java.util.List;

public interface CommentService {
    List<CommentFullDto> findAll();
    CommentFullDto findById(long id);
    void save(CommentFullDto object);
    void deleteById(long id);
    void update(long id,CommentFullDto object);
}
