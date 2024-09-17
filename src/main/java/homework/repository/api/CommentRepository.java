package homework.repository.api;

import homework.entity.Comment;

import java.util.List;

public interface CommentRepository {
    Comment findById(Long id);
    List<Comment> findAll();
    void save(Comment comment);
    void deleteById(Long id);
    void update(Comment comment);
    List<Comment> findByCommentTextCriteria(String commentText);
    List<Comment> findAllWithAssociationsEntityGraph();
    List<Comment> findAllWithAssociationsJPQL();
}
