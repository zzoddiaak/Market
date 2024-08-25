package homework.repository.impl;

import homework.entity.Comment;
import homework.entity.User;
import homework.repository.AbstractRepository;
import homework.repository.api.CommentRepository;
import homework.repository.api.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

public class CommentRepositoryImpl extends AbstractRepository<Comment> implements CommentRepository {
    private UserRepository userRepository;


    public CommentRepositoryImpl() {
        this.userRepository = new UserRepositoryImpl();
        initializeData();
    }
    private void initializeData(){
        User user = userRepository.findById(1L);

        save(Comment.builder()
                .user(user)
                .commentText("Norm")
                .createdAt(LocalDateTime.of(2024, 7, 1, 10, 0))
                .build());
    }
}
