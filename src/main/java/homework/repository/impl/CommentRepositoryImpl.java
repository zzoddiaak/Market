package homework.repository.impl;

import homework.entity.Comment;
import homework.entity.Comment_;
import homework.repository.AbstractRepository;
import homework.repository.api.CommentRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentRepositoryImpl extends AbstractRepository<Long, Comment> implements CommentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public CommentRepositoryImpl() {
        super(Comment.class);
    }

    // JPQL запрос: Поиск по тексту комментария
    public List<Comment> findByCommentTextJPQL(String commentText) {
        TypedQuery<Comment> query = entityManager.createQuery(
                "SELECT c FROM Comment c WHERE c.commentText LIKE :commentText", Comment.class);
        query.setParameter("commentText", "%" + commentText + "%");
        return query.getResultList();
    }

    // Criteria API запрос: Поиск по тексту комментария
    public List<Comment> findByCommentTextCriteria(String commentText) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comment> query = cb.createQuery(Comment.class);
        Root<Comment> root = query.from(Comment.class);

        Predicate predicate = cb.like(root.get(Comment_.commentText), "%" + commentText + "%");
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }

    // Обновление данных
    public void update(Long id, Comment comment) {
        Comment existingComment = findById(id);
        if (existingComment != null) {
            existingComment.setCommentText(comment.getCommentText());
            existingComment.setCreatedAt(comment.getCreatedAt());
            existingComment.setUser(comment.getUser());
            entityManager.merge(existingComment);
        }
    }
}
