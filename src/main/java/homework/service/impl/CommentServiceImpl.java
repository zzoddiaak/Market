package homework.service.impl;

import homework.dto.DtoMapperService;
import homework.dto.comment.CommentFullDto;
import homework.entity.Comment;
import homework.repository.api.CommentRepository;
import homework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository repository;
    private final DtoMapperService mapperService;

    @Override
    public List<CommentFullDto> findAll() {
        return repository.findAll().stream()
                .map(comment -> mapperService.convertToDto(comment, CommentFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentFullDto findById(long id) {
        Comment comment = repository.findById(id);
        return mapperService.convertToDto(comment, CommentFullDto.class);
    }

    @Override
    public void save(CommentFullDto object) {
        Comment comment = mapperService.convertToEntity(object, Comment.class);
        repository.save(comment);
    }

    @Override
    public void update(long id, CommentFullDto updateDTO) {
        Comment comment  = mapperService.convertToEntity(updateDTO, Comment.class);
        repository.update(id, comment);
    }

    @Override
    public void deleteById(long id) {
        repository.deleteById(id);

    }
}
