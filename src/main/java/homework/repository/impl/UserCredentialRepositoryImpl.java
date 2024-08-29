package homework.repository.impl;

import homework.entity.UserCredential;
import homework.repository.AbstractRepository;
import homework.repository.api.UserCredentialRepository;
import java.time.LocalDateTime;
import org.springframework.stereotype.Repository;


@Repository
public class UserCredentialRepositoryImpl extends AbstractRepository<UserCredential> implements UserCredentialRepository {
    public UserCredentialRepositoryImpl() {
        save(UserCredential.builder()
                .createdAt(LocalDateTime.of(2024, 7, 1, 10, 0))
                .password("12312321312")
                .username("Andrew")
                .build());

        save(UserCredential.builder()
                .createdAt(LocalDateTime.of(2024, 9, 1, 12, 0))
                .password("1sdf21312")
                .username("Daniil")
                .build());
    }

}
