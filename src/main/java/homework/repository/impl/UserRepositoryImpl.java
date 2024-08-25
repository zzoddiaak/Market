package homework.repository.impl;

import homework.entity.User;
import homework.entity.UserCredential;
import homework.repository.AbstractRepository;
import homework.repository.api.UserCredentialRepository;
import homework.repository.api.UserRepository;

import java.time.LocalDateTime;

public class UserRepositoryImpl extends AbstractRepository<User> implements UserRepository {
    private UserCredentialRepository userCredentialRepository;

    public UserRepositoryImpl() {
        this.userCredentialRepository = new UserCredentialRepositoryImpl();
        initializeData();
    }
    private void initializeData() {
        UserCredential user = userCredentialRepository.findById(1L);
        UserCredential user2 = userCredentialRepository.findById(2L);

        save(User.builder()
                .bio("Нормис")
                .createdAt(LocalDateTime.of(2024, 7, 1, 10, 0))
                .credential(user)
                .lastName("Андрей")
                .firstName("Иванов")
                .build());

        save(User.builder()
                .bio("Не нормис")
                .createdAt(LocalDateTime.of(2024, 9, 1, 12, 0))
                .credential(user2)
                .lastName("Даниил")
                .firstName("Иванов")
                .build());
    }
}
