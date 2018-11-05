package io.ricobot.movie.app.repository;

import io.ricobot.movie.app.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface RoleRepository extends JpaRepository<Role, Long> {

}