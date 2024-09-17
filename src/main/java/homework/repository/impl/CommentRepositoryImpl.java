package homework.repository.impl;

import homework.entity.Comment;
import homework.entity.Comment_;
import homework.repository.AbstractRepository;
import homework.repository.api.CommentRepository;
import jakarta.persistence.EntityGraph;
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

    @Override
    public List<Comment> findAllWithAssociationsJPQL() {
        String jpql = "SELECT c FROM Comment c " +
                "LEFT JOIN FETCH c.user";
        TypedQuery<Comment> query = entityManager.createQuery(jpql, Comment.class);

        return query.getResultList();
    }

    @Override
    public List<Comment> findAllWithAssociationsEntityGraph() {
        EntityGraph<Comment> graph = entityManager.createEntityGraph(Comment.class);

        graph.addAttributeNodes("user");

        TypedQuery<Comment> query = entityManager.createQuery("SELECT c FROM Comment c", Comment.class);
        query.setHint("javax.persistence.fetchgraph", graph);

        return query.getResultList();
    }


    @Override
    public List<Comment> findByCommentTextCriteria(String commentText) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Comment> query = cb.createQuery(Comment.class);
        Root<Comment> root = query.from(Comment.class);

        Predicate predicate = cb.like(root.get(Comment_.commentText), "%" + commentText + "%");
        query.select(root).where(predicate);

        return entityManager.createQuery(query).getResultList();
    }


}
