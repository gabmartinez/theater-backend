package io.ricobot.movie.app.repository;

import io.ricobot.movie.app.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
