package homework.repository.impl;

import homework.entity.Comment;
import homework.entity.User;
import homework.repository.AbstractRepository;
import homework.repository.api.CommentRepository;
import homework.repository.api.UserRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Repository;


@Repository
public class CommentRepositoryImpl extends AbstractRepository<Comment> implements CommentRepository {
    private UserRepository userRepository;


    public CommentRepositoryImpl() {
        this.userRepository = new UserRepositoryImpl();
        initializeData();
    }
    private void initializeData(){
        User user = userRepository.findById(1L);
        User user1 = userRepository.findById(2L);

        save(Comment.builder()
                .user(user)
                .commentText("Norm")
                .createdAt(LocalDateTime.of(2024, 7, 1, 10, 0))
                .build());

        save(Comment.builder()
                .user(user1)
                .commentText("Ne Norm")
                .createdAt(LocalDateTime.of(2024, 12, 3, 12, 0))
                .build());
    }
}
