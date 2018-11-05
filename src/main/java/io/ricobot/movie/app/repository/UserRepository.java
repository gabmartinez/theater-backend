package io.ricobot.movie.app.repository;

import io.ricobot.movie.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
