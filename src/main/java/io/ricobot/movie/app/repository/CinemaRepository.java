package io.ricobot.movie.app.repository;

import io.ricobot.movie.app.model.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
