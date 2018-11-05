package io.ricobot.movie.app.repository;

import io.ricobot.movie.app.model.Cinema;
import io.ricobot.movie.app.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAllByCinemasEquals(Cinema cinema);
}
