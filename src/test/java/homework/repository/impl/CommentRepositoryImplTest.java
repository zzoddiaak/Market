package homework.repository.impl;

import homework.config.DatabaseConfig;
import homework.config.LiquibaseConfig;
import homework.entity.Comment;
import homework.repository.api.CommentRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class, LiquibaseConfig.class}, loader = AnnotationConfigContextLoader.class)
@Transactional
public class CommentRepositoryImplTest {

    @Resource
    private CommentRepository commentRepository;

    @Test
    public void findByCommentTextCriteria() {
        Comment comment = Comment.builder().commentText("Great service!").build();
        commentRepository.save(comment);

        List<Comment> comments = commentRepository.findByCommentTextCriteria("Great");
        assertNotNull(comments);
        assertFalse(comments.isEmpty());

        comments.forEach(c -> assertTrue(c.getCommentText().contains("Great")));
    }

    @Test
    public void findAllWithAssociationsJPQL() {
        List<Comment> comments = commentRepository.findAllWithAssociationsJPQL();
        assertNotNull(comments);
        assertFalse(comments.isEmpty());
    }

    @Test
    public void findAllWithAssociationsEntityGraph() {
        List<Comment> comments = commentRepository.findAllWithAssociationsEntityGraph();
        assertNotNull(comments);
        assertFalse(comments.isEmpty());
    }
}
