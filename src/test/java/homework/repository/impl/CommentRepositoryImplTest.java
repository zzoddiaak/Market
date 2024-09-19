package homework.repository.impl;

import homework.config.test.TestConfig;
import homework.entity.Comment;
import homework.repository.api.CommentRepository;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.List;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class})
@Transactional
public class CommentRepositoryImplTest {

    @Resource
    private CommentRepository commentRepository;

    @Before
    public void setUp() {
        Comment comment1 = Comment.builder().commentText("Great service!").build();
        Comment comment2 = Comment.builder().commentText("Very satisfied with the product.").build();
        Comment comment3 = Comment.builder().commentText("Could be better.").build();

        commentRepository.save(comment1);
        commentRepository.save(comment2);
        commentRepository.save(comment3);
    }

    @Test
    public void findByCommentTextCriteria() {
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
