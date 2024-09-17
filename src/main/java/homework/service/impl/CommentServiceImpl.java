package homework.service.impl;

import homework.dto.DtoMapper;
import homework.dto.category.CategoryFullDto;
import homework.dto.comment.CommentFullDto;
import homework.entity.Comment;
import homework.repository.api.CommentRepository;
import homework.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository repository;
    private final DtoMapper mapper;

    @Override
    public List<CommentFullDto> findAll() {

        return repository.findAll().stream()
                .map(comment -> mapper.convertToDto(comment, CommentFullDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CommentFullDto findById(long id) {
        Comment comment = repository.findById(id);

        return mapper.convertToDto(comment, CommentFullDto.class);
    }

    @Override
    public void save(CommentFullDto object) {
        Comment comment = mapper.convertToEntity(object, Comment.class);
        repository.save(comment);
    }

    @Override
    public void update(long id, CommentFullDto updateDTO) {
        Comment comment  = mapper.convertToEntity(updateDTO, Comment.class);
        repository.update(comment);
    }
    @Override
    public void deleteById(long id) {
        repository.deleteById(id);

    }
}
