package homework.service.impl;

import homework.config.AppConfig;
import homework.dto.DtoMapper;
import homework.dto.comment.CommentFullDto;
import homework.entity.Comment;
import homework.repository.api.CommentRepository;
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

import java.time.LocalDateTime;
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
class CommentServiceImplTest {

    @InjectMocks
    private CommentServiceImpl commentService;

    @Spy
    private CommentRepository commentRepository;

    @Mock
    private DtoMapper mapper;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void findAll() {
        Comment comment1 = new Comment(1L, "Great product!", LocalDateTime.now(), null);
        Comment comment2 = new Comment(2L, "Not satisfied", LocalDateTime.now(), null);

        when(commentRepository.findAll()).thenReturn(List.of(comment1, comment2));

        CommentFullDto dto1 = new CommentFullDto();
        dto1.setCommentText("Great product!");
        CommentFullDto dto2 = new CommentFullDto();
        dto2.setCommentText("Not satisfied");

        when(mapper.convertToDto(comment1, CommentFullDto.class)).thenReturn(dto1);
        when(mapper.convertToDto(comment2, CommentFullDto.class)).thenReturn(dto2);

        List<CommentFullDto> actual = commentService.findAll();

        verify(commentRepository, times(1)).findAll();
        assertFalse(actual.isEmpty());
        assertEquals(2, actual.size());
        assertEquals("Great product!", actual.get(0).getCommentText());
        assertEquals("Not satisfied", actual.get(1).getCommentText());
    }

    @Test
    void findById() {
        long id = 1L;
        Comment comment = new Comment(id, "Great product!", LocalDateTime.now(), null);

        when(commentRepository.findById(id)).thenReturn(comment);

        CommentFullDto expectedDto = new CommentFullDto();
        expectedDto.setCommentText("Great product!");

        when(mapper.convertToDto(comment, CommentFullDto.class)).thenReturn(expectedDto);

        CommentFullDto actual = commentService.findById(id);

        verify(commentRepository, times(1)).findById(id);
        assertNotNull(actual);
        assertEquals(expectedDto.getCommentText(), actual.getCommentText());
    }

    @Test
    void save() {
        CommentFullDto commentDto = new CommentFullDto();
        commentDto.setCommentText("Great product!");

        Comment comment = new Comment();
        comment.setCommentText("Great product!");

        when(mapper.convertToEntity(commentDto, Comment.class)).thenReturn(comment);

        doNothing().when(commentRepository).save(any(Comment.class));

        commentService.save(commentDto);

        verify(commentRepository, times(1)).save(comment);
    }

    @Test
    void update() {
        long id = 1L;
        CommentFullDto updateDto = new CommentFullDto();
        updateDto.setCommentText("Updated comment");

        Comment existingComment = new Comment(id, "Great product!", LocalDateTime.now(), null);
        Comment updatedComment = new Comment(id, "Updated comment", LocalDateTime.now(), null);

        when(commentRepository.findById(id)).thenReturn(existingComment);
        when(mapper.convertToEntity(updateDto, Comment.class)).thenReturn(updatedComment);

        doNothing().when(commentRepository).update(any(Comment.class));

        commentService.update(id, updateDto);

        verify(commentRepository, times(1)).update(updatedComment);
    }

    @Test
    void deleteById() {
        long id = 1L;

        commentService.deleteById(id);

        verify(commentRepository, times(1)).deleteById(id);
    }
}
