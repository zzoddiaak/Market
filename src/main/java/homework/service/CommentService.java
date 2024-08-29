package homework.service;

import homework.dto.comment.CommentFullDto;

import java.util.List;

public interface CommentService {
    List<CommentFullDto> findAll();
    CommentFullDto findById(long id);
    void save(CommentFullDto object);
    void update(long id,CommentFullDto  updateDTO);
    void deleteById(long id);
}
